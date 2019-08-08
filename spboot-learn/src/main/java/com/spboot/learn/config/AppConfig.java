package com.spboot.learn.config;

import com.spboot.learn.condition.DatabaseConditional;
import com.spboot.learn.service.UserService;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
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
//,excludeFilters = {@ComponentScan.Filter(classes = Service.class)},,lazyInit = true
@ComponentScan(value = "com.spboot.learn.*" )
@ImportResource(value = "classpath:XMLBean/spring-other.xml")
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
    @Bean(name = "dataSource",destroyMethod = "close")
    @Conditional(DatabaseConditional.class)
    //@Profile("dev")
    public DataSource getDataSource(@Value("${spring.datasource.driver-class-name}")String driver,
                                    @Value("${spring.datasource.url}")String url,
                                    @Value("${spring.datasource.username}")String username,
                                    @Value("${spring.datasource.password}")String password){

        Properties properties=new Properties();
        properties.setProperty("driver",driver);
        properties.setProperty("url",url);
        properties.setProperty("username",username);
        properties.setProperty("password",password);

        DataSource dataSource=null;
        try{
            dataSource= BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
