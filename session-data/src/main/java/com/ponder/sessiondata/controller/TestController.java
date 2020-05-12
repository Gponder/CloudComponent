package com.ponder.sessiondata.controller;

import com.ponder.sessiondata.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/8 20:39
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("name")
    public String get(){
        Object name = redisUtil.get("name");
        return String.valueOf(name);
    }

    @PutMapping("name")
    public boolean put(String name){
        return redisUtil.set("name",name);
    }

}
