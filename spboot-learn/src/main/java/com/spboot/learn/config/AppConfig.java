package com.spboot.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author feifei
 * @Classname AppConfig
 * @Description TODO
 * @Date 2019/7/29 15:13
 * @Created by ChenS
 */
@Configuration
@ComponentScan("com.spboot.learn.*")
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
