package com.spboot.learn.service;

import com.spboot.learn.model.User;
import org.springframework.stereotype.Service;

/**
 * @author feifei
 * @Classname DBUserService
 * @Description TODO
 * @Date 2019/7/29 15:54
 * @Created by ChenS
 */
@Service
public class UserService {
    public void printUser(User user){
        System.out.println(user.getId());
        System.out.println(user.getUserName());
        System.out.println(user.getNote());
    }
}
