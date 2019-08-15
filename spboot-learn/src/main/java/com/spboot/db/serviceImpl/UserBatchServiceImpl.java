package com.spboot.db.serviceImpl;

import com.spboot.db.pojo.User;
import com.spboot.db.service.DBUserService;
import com.spboot.db.service.UserBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author feifei
 * @Classname UserBatchServiceImpl
 * @Description TODO
 * @Date 2019/8/14 20:46
 * @Created by ChenS
 */

@Service
public class UserBatchServiceImpl implements UserBatchService {

    @Autowired
    private DBUserServiceImpl userServiceImpl=null;


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int insertUsers(List<User> userList) {
        int count=0;
        for (User user:userList) {
            System.out.println(user.getUsername()+user.getNote());
            count+=userServiceImpl.insertUser(user);
        }
        return count;
    }
}
