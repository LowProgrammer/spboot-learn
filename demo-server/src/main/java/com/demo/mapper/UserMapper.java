package com.demo.mapper;

import com.demo.model.User;
import com.demo.service.StringRedisService;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    //static final Logger logger = LoggerFactory.getLogger(UserMapper.class);
    void insert(User user);

    List<User> findAll();

    void delete(String name);

    void update(User user);

    User select(String name);
}
