package com.ponder.technology.proxy;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/29 18:09
 */
public class AOPClass implements AOPInterface,AOPInterfaceParam {
    @Override
    public void doing() {
        System.out.println("doing");
    }

    @Override
    public String doing(String param) {
        System.out.println("doing:"+param);
        return param;
    }
}
