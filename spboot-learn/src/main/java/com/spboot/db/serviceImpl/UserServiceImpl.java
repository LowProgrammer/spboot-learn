package com.spboot.db.serviceImpl;

import com.spboot.db.dao.UserDao;
import com.spboot.db.pojo.User;
import com.spboot.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author feifei
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2019/8/13 15:34
 * @Created by ChenS
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao=null;
    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }
}
