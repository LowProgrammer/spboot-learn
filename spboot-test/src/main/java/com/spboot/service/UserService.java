package com.spboot.service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.spboot.pojo.User;

import java.util.List;

/**
 * @author feifei
 * @Classname UserService
 * @Description TODO
 * @Date 2019/9/10 15:30
 * @Created by 陈群飞
 */
public interface UserService {
    public void saveUser(User user);
    public DeleteResult deleteUser(Long id);
    public List<User> findUser(String userName,String note,int skip,int limit);
    public UpdateResult updateUser(Long id,String userName,String note);
    public User getUser(Long id);
}
