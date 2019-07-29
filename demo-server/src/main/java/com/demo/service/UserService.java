package com.demo.service;

import com.demo.mapper.UserMapper;
import com.demo.model.Role;
import com.demo.model.User;
import com.demo.redis.UserRedis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2019/7/24 18:10
 * @Created by ChenS
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRedis userRedis;
    private static final String keyHead = "mysql:get:user:";

    public User findByName(String name) {
        logger.info(userMapper.select(name).toString());
        User user = userMapper.select(name);
        System.out.println("user find mysql:" + user.getName() + "===" + user.getAge()+user.getDepartMent().toString()
                +"=="+user.getUserRoles().toArray().toString()
        );
        Set<Role> roles=user.getUserRoles();
            Iterator<Role> it=roles.iterator();
            while(it.hasNext()){
                Role r=it.next();
                System.out.println(r.getName()+"===="+r.getCreateDate());
            }

        System.out.println(user.toString());
//        User user = userRedis.get(keyHead + name);
//        System.out.println("user redis:" + user.getName() + "===" + user.getAge());
//        if (user == null) {
//            user = userMapper.select(name);
//            System.out.println("user find mysql:" + user.getName() + "===" + user.getAge()+user.getDepartMent().toString()
//                    +"=="+user.getUserRoles().toArray().toString()
//            );
//            if (user != null) {
//                userRedis.add(keyHead + name, 30L, user);
//            }
//        }
        return user;
    }

    public void addUser(User user) {
        userMapper.insert(user);
        System.out.println("user save mysql:" + user.getName() + "===" + user.getAge());
        System.out.println("save....");
        userRedis.add(keyHead + user.getName(), 30L, user);

//        User user1;
//        if((user1=userRedis.get(keyHead+user.getName()))!=null) {
//            userRedis.add(keyHead + user.getName(), 30L, user);
//            userRedis.setObj(keyHead+user.getName(),user);
//            System.out.println("save to redis");
//        }
    }

    public void update(User user) {
        User re = userRedis.get(keyHead + user.getName());
        System.out.println("user redis (update):" + user.getName() + "===" + user.getAge());
        if (re != null) {
            userRedis.add(keyHead + user.getName(), 30L, user);
            System.out.println("redis update");
//            userRedis.delete(keyHead+user.getName());
//            userRedis.add(keyHead+user.getName(),30L,user);
        }
        userMapper.update(user);
    }

    public void delete(User user) {
        User user1;
        userMapper.delete(user.getName());
        System.out.println("user mysql(delete):" + user.getName() + "===" + user.getAge());

        if ((user1 = userRedis.get(keyHead + user.getName())) != null) {
            userRedis.delete(keyHead + user.getName());
        }
    }
}
