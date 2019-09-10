package com.spboot.redis.dao;

import com.spboot.redis.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author feifei
 * @Classname UserDao
 * @Description TODO
 * @Date 2019/9/5 11:00
 * @Created by 陈群飞
 */
@Repository
public interface UserDaoTe {
    User getUser(Long id);

    int insertUser(User user);

    int updateUser(User user);

    List<User> findUsers(@Param("userName")String userName,@Param("note") String note);

    int deleteUser(Long id);
}
