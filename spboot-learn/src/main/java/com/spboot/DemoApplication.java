package com.spboot;

import com.spboot.aop.MyAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

/**
 * @author feifei
 * @Classname DemoApplication
 * @Description TODO
 * @Date 2019/7/29 14:10
 * @Created by ChenS
 */
@SpringBootApplication(scanBasePackages = {"com.spboot"})
@MapperScan(basePackages = "com.spboot.db.*")
public class DemoApplication {
//    @Bean(name = "myaspect")
//    public MyAspect initMyAspect(){
//        return new MyAspect();
//    }

    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class,args);
    }


    @Autowired
    PlatformTransactionManager transactionManager=null;

    @PostConstruct
    public void viewTranscationManager(){
        System.out.println(transactionManager.getClass().getName());
    }
}
