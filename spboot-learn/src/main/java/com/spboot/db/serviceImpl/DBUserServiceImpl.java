package com.spboot.db.serviceImpl;

import com.spboot.db.dao.UserDao;
import com.spboot.db.pojo.User;
import com.spboot.db.service.DBUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author feifei
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2019/8/13 15:34
 * @Created by ChenS
 */
@Service
public class DBUserServiceImpl implements DBUserService {
    @Autowired
    private UserDao userDao=null;
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public User getUser(Long id) {
        User u= userDao.getUser(id);
        System.out.println(u.getUsername());
        System.out.println(u.getNote());
        System.out.println(u.getSex());
        return u;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public int insertUser(User user) {
        int i=userDao.insertUser(user);

        return i;
    }
}
