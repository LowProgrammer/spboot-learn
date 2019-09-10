package com.spboot.redis.service;

import com.spboot.redis.pojo.User;

import java.util.List;

/**
 * @author feifei
 * @Classname UserService
 * @Description TODO
 * @Date 2019/9/5 11:52
 * @Created by 陈群飞
 */
public interface UserService {
    User getUser(Long id);

    User insertUser(User user);

    User updateUserName(Long id,String userName);

    List<User> findUsers(String userName,String note);

    int deleteUser(Long id);
}
