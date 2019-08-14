package com.spboot.db.service;

import com.spboot.db.pojo.User;

/**
 * @author feifei
 * @Classname DBUserService
 * @Description TODO
 * @Date 2019/8/13 15:33
 * @Created by ChenS
 */
public interface DBUserService {
    public User getUser(Long id);

    public int insertUser(User user);
}
