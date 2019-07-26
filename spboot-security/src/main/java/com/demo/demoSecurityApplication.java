package com.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname demoServerApplication
 * @Description TODO
 * @Date 2019/6/22 16:56
 * @Created by ChenS
 */
@SpringBootApplication
//@MapperScan("com.demo.mapper")
//@ServletComponentScan
public class demoSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(demoSecurityApplication.class, args);
    }

//    private void getNum(String title) {
//        int len = title.length();
//
//        Set<String> list;
//    }
//
//    private Set<String> getDifferent(String title, int num) {
//        Set<String> res = new HashSet<>();
//        int ind[] = new int[num];
//
//        for (int i = 0; i < num; i++) {
//
//        }
//        return res;
//    }
}
