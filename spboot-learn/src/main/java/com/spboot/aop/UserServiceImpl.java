package com.spboot.aop;

import com.spboot.learn.model.User;
import org.springframework.stereotype.Service;

/**
 * @author feifei
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2019/8/9 14:22
 * @Created by ChenS
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if(user==null){
            throw new  RuntimeException("检查参数是否为空");
        }
        System.out.println("id:"+user.getId());
        System.out.println("name:"+user.getUserName());
        System.out.println("note:"+user.getNote());
    }
}
