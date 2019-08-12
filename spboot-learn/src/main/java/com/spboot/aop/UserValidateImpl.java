package com.spboot.aop;

import com.spboot.learn.model.User;

/**
 * @author feifei
 * @Classname UserValidateImpl
 * @Description TODO
 * @Date 2019/8/12 15:13
 * @Created by ChenS
 */
public class UserValidateImpl implements UserValidator {
    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口："+UserValidator.class.getSimpleName());
        return user!=null;
    }
}
