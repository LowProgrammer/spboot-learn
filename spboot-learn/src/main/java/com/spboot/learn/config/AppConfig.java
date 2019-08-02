package com.spboot.learn.config;

import com.spboot.learn.service.UserService;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author feifei
 * @Classname AppConfig
 * @Description TODO
 * @Date 2019/7/29 15:13
 * @Created by ChenS
 */
@Configuration
//,excludeFilters = {@ComponentScan.Filter(classes = Service.class)}
@ComponentScan(value = "com.spboot.learn.*" ,lazyInit = true)
public class AppConfig {

//    @Bean(name = "user")
//    public User initUser(){
//        User user=new User();
//        user.setId(1L);
//        user.setUserName("user_name_1");
//        user.setNote("note_1");
//        return user;
//    }

    /**
     *@description DBCP生成数据源
     *@param
     *@returns
     *@author feifei
     *@data 2019/7/31
     */
   @Bean(name = "dataSource")
    public DataSource getDataSource(){
       Properties properties=new Properties();
       properties.setProperty("driver","com.mysql.jdbc.Driver");
       properties.setProperty("url","jdbc://localhost:3306/test");
       properties.setProperty("username","root");
       properties.setProperty("password","root");
       DataSource dataSource=null;
       try{
            dataSource= BasicDataSourceFactory.createDataSource(properties);
       }catch (Exception e){
            e.printStackTrace();
       }
       return dataSource;
    }
}
