package com.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Classname StringRedisService
 * @Description TODO
 * @Date 2019/7/25 13:50
 * @Created by ChenS
 */
@Service
public class StringRedisService {
    private static final Logger logger = LoggerFactory.getLogger(StringRedisService.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public void setString(String key, String value) {
        logger.info("--------------------->[Redis set start]");
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String getString(String key) {
        logger.info("--------------------->[Redis get start]");
        return stringRedisTemplate.opsForValue().get(key);
    }

}
