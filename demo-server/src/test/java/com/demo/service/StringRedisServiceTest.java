package com.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringRedisServiceTest {

    @Autowired
    private StringRedisService stringRedisService;

    @Test
    public void setString() {
        stringRedisService.setString("name", "张三");
    }

    @Test
    public void getString() {
        System.out.println(stringRedisService.getString("name"));
    }
}