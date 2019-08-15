package com.spboot.db.controller;

import com.spboot.db.pojo.User;
import com.spboot.db.service.UserBatchService;
import com.spboot.db.serviceImpl.DBUserServiceImpl;
import com.spboot.db.serviceImpl.UserBatchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feifei
 * @Classname dbController
 * @Description TODO
 * @Date 2019/8/14 11:55
 * @Created by ChenS
 */
@Controller
@RequestMapping("/db")
public class dbController {

    @Autowired
    private DBUserServiceImpl userServiceImpl=null;
    @Autowired
    private UserBatchServiceImpl userBatchService=null;

    @RequestMapping("/print")
    @ResponseBody
    public String test(Long id){
        User dbuser=userServiceImpl.getUser(id);

        return dbuser.getUsername()+dbuser.getSex();
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public Map<String,Object> insertUser(String userName,String note){
        User user=new User();
        user.setUsername(userName);
        user.setNote(note);
        int up=userServiceImpl.insertUser(user);
        Map<String,Object> result=new HashMap<>();
        result.put("success",up==1);
        result.put("user",user);
        return result;
    }


    @RequestMapping("/insertUserList")
    @ResponseBody
    public Map<String,Object> insertUser(String userName1,String note1,String userName2,String note2){
        User user1=new User();
        user1.setUsername(userName1);
        user1.setNote(note1);
        User user2=new User();
        user2.setUsername(userName2);
        user2.setNote(note2);
        List<User> userList=new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        int inserts=userBatchService.insertUsers(userList);
        Map<String,Object> result=new HashMap<>();
        result.put("success",inserts>0);
        result.put("user",userList);
        return result;
    }
}
