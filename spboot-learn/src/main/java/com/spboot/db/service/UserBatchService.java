package com.spboot.db.service;

import com.spboot.db.pojo.User;

import java.util.List;

/**
 * @author feifei
 * @Classname UserBatchService
 * @Description TODO
 * @Date 2019/8/14 20:44
 * @Created by ChenS
 */
public interface UserBatchService {
    public int insertUsers(List<User> userList);
}
