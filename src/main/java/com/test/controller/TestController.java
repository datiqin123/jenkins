package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwh
 * @create 2021-04-09 19:29
 */

@RestController
public class TestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/testRedis")
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("test","aaa");
    }

    @PostMapping("/testMySql")
    public void testMySql() {
        User user = new User();
        user.setId("1");
        user.setAge(10);
        userMapper.insert(user);
    }

}
