package com.spboot.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author feifei
 * @Classname RedisConfig
 * @Description TODO
 * @Date 2019/9/4 10:18
 * @Created by 陈群飞
 */
//@Configuration
public class RedisConfig {
    private RedisConnectionFactory connectionFactory=null;

    @Bean(name = "RedisConnectionFactory")
    public RedisConnectionFactory initRedisConnectionFactory(){
        if (this.connectionFactory!=null){
            return this.connectionFactory;
        }
        JedisPoolConfig poolConfig=new JedisPoolConfig();

        poolConfig.setMaxIdle(30);

        poolConfig.setMaxTotal(50);

        poolConfig.setMaxWaitMillis(2000);
        JedisConnectionFactory connectionFactory=new JedisConnectionFactory(poolConfig);

        RedisStandaloneConfiguration rsCfg=connectionFactory.getStandaloneConfiguration();
        connectionFactory.setHostName("10.100.2.124");
        connectionFactory.setPort(6379);

        this.connectionFactory=connectionFactory;
        return connectionFactory;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object,Object> initRedisTemplate(){
        RedisTemplate<Object,Object> redisTemplate=new RedisTemplate<>();

        RedisSerializer stringRedisSerializer=redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);

        redisTemplate.setConnectionFactory(initRedisConnectionFactory());
        return redisTemplate;
    }
}
