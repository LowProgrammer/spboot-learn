package com.spboot.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author feifei
 * @Classname IndexController
 * @Description TODO
 * @Date 2019/7/29 14:01
 * @Created by ChenS
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
