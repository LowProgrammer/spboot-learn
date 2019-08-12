package com.spboot.aop;

import com.spboot.learn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author feifei
 * @Classname UserController
 * @Description TODO
 * @Date 2019/8/9 16:34
 * @Created by ChenS
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService=null;

    @RequestMapping("/print")
    @ResponseBody
    public User printUser(Long id,String userName,String note){
        User user=new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        //user=null;
        userService.printUser(user);
        return user;
    }
}
