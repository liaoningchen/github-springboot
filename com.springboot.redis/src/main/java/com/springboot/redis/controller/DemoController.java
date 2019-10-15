package com.springboot.redis.controller;

import com.springboot.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DemoController {
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/demo")
    public String demo() {
        redisUtil.set("test",new Date());
        return (String) redisUtil.get("test");
    }
}
