package com.spboot.aop;

import com.spboot.learn.model.User;

/**
 * @author feifei
 * @Classname UserValidator
 * @Description TODO
 * @Date 2019/8/12 15:11
 * @Created by ChenS
 */
public interface UserValidator {
    public boolean validate(User user);
}
