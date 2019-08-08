package com.spboot.learn.config;

import com.spboot.learn.condition.DatabaseConditional;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author feifei
 * @Classname DataBaseProperties
 * @Description TODO
 * @Date 2019/8/2 17:33
 * @Created by ChenS
 */

@Component
@ConfigurationProperties("spring.datasource")
public class DataBaseProperties {



    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName=null;

    @Value("${spring.datasource.url}")
    private String url;

    private String username=null;

    private String password=null;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        System.out.println("1"+driverClassName);
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        System.out.println("2"+url);
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    @Value("${spring.datasource.username}")
    public void setUsername(String username) {
        System.out.println("3"+username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Value("${spring.datasource.password}")
    public void setPassword(String password) {
        System.out.println("4"+password);
        this.password = password;
    }
}
