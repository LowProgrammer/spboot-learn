package com.spboot.learn.config;

import com.spboot.learn.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author feifei
 * @Classname AppConfig
 * @Description TODO
 * @Date 2019/7/29 15:13
 * @Created by ChenS
 */
@Configuration
@ComponentScan(value = "com.spboot.learn.*" ,excludeFilters = {@ComponentScan.Filter(classes = Service.class)})
public class AppConfig {

//    @Bean(name = "user")
//    public User initUser(){
//        User user=new User();
//        user.setId(1L);
//        user.setUserName("user_name_1");
//        user.setNote("note_1");
//        return user;
//    }
}
