package com.demo.redis;

import com.alibaba.druid.util.StringUtils;
import com.demo.model.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Classname UserRedis
 * @Description TODO
 * @Date 2019/7/24 18:06
 * @Created by ChenS
 */
@Repository
//@Service
public class UserRedis {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void add(String key, Long time, User user) {
        Gson gson = new Gson();
        System.out.println(key + ":" + user + ":" + time + ":" + TimeUnit.MINUTES);
        redisTemplate.opsForValue().set(key, gson.toJson(user), time, TimeUnit.MINUTES);
    }

    public User get(String key) {
        Gson gson = new Gson();
        User user = null;
        String json = redisTemplate.opsForValue().get(key);
        System.out.println("get json=========" + json);
        try {
            if (json != null && !StringUtils.isEmpty(json)) {
                user = gson.fromJson(json, User.class);
            }
        } catch (NullPointerException no) {
            no.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    //    public User get(String key){
//        User usr=(User)redisTemplate.opsForValue().get(key);
//        return usr;
//    }
    public void delete(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
    }

    public void setObj(String key, User value) {
        redisTemplate.opsForValue().set(key, value.toString(), 30L, TimeUnit.MINUTES);
    }
}
