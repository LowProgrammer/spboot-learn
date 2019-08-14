package com.spboot.db.dao;

import com.spboot.db.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author feifei
 * @Classname UserDao
 * @Description TODO
 * @Date 2019/8/13 14:46
 * @Created by ChenS
 */
@Repository //使用@Mapper也可以
public interface UserDao{
    /**
     *@description
     *@param id
     *@returns User
     *@author feifei
     *@data 2019/8/14
     */
    public User getUser(Long id);

    /**
     *@description
     *@param user
     *@returns resultSet
     *@author feifei
     *@data 2019/8/14
     */
    public int insertUser(User user);
}
