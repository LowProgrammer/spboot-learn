package com.demo.mapper;

import com.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 2019/7/24 17:53
 * @Created by ChenS
 */
@Mapper
@Component
public interface UserMapper {
    void insert(User user);

    List<User> findAll();

    void delete(String name);

    void update(User user);

    User select(String name);
}
