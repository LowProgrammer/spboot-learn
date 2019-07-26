package com.demo.controller;

import com.demo.model.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Classname Democoller
 * @Description TODO
 * @Date 2019/7/24 18:18
 * @Created by ChenS
 */
@RestController
public class Democoller {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test() {
        return "hello world";
    }

    @RequestMapping("/add")
    private String addUser() {
        User user = new User();
        String sy = "周杰伦";
        try {
            //user.setName(new String(sy.getBytes("utf-8"), "utf-8"));
            //user.setName(URLDecoder.decode("周杰伦","utf-8"));
            user.setName("王思聪");
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setAge(37);
        userService.addUser(user);
        return "success";
    }

    @RequestMapping("/find")
    private String findUser(String name) {
        User user = userService.findByName("周杰伦");
        System.out.println("find......success");
        return "success" + user.getName() + "====" + user.getAge();
    }

    @RequestMapping("/update")
    private String updateUser() {
        User user = new User();
        user.setName("周杰伦");
        user.setAge(35);
        userService.update(user);
        return "success update" + user.getName() + "====" + user.getAge();
    }
}
