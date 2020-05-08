package com.ponder.sessiondata.config;

import com.alibaba.fastjson.JSONObject;
import com.ponder.sessiondata.common.exception.BaseErrorCode;
import com.ponder.sessiondata.common.exception.BaseException;
import com.ponder.sessiondata.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/8 17:49
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object token = request.getParameter("token");
        String userId = request.getParameter("userId");
        if(token == null || userId == null) {
            JSONObject json = new JSONObject();
            json.put("code","10005");
            json.put("msg","登陆验证失败,请重新登陆！");
            response.setHeader("Access-Control-Allow-Origin","*");
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(200);
            response.getWriter().write(json.toString());
            return false;
        }
        try {
            // 获取key过期时间
            Long expireTime = redisUtil.getExpire(userId);
            if(expireTime < 0) { // key不存在则登录超时
                JSONObject json = new JSONObject();
                json.put("code","10005");
                json.put("msg","登陆超时,请重新登陆！");
                response.setHeader("Access-Control-Allow-Origin","*");
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(200);
                response.getWriter().write(json.toString());
                return false;
            }
            if(expireTime < 60*5) {// 如果过期时间小于5分钟秒则重置过期时间
                redisUtil.expire(userId,30*60);
            }
//            user = (UserBean)RedisUtil.get(userId);// redis单机
//            user = (UserBean) RedisClusterUtil.getObject(userId.toString());//redis哨兵
        }catch (Exception ex) {
//            return true;//ruturn true 是为了当redis连接出问题时程序能正常运行,但没有进行登陆过期的判断
            ex.printStackTrace();
            throw new BaseException("Redis连接异常",
                    BaseErrorCode.VALIDATOR_ERROR);
        }
        return true;
    }
}
