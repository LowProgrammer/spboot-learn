package com.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Classname SecuritySettings
 * @Description TODO
 * @Date 2019/7/26 10:05
 * @Created by ChenS
 */

@ConfigurationProperties(prefix="securityconfig")
public class SecuritySettings {
    private String permitall = "/api";
    private String logoutsuccssurl = "/logout";
    private String deniedpage = "/deny";
    private String urlroles;

    public String getLogoutsuccssurl() {
        return logoutsuccssurl;
    }

    public void setLogoutsuccssurl(String logoutsuccssurl) {
        this.logoutsuccssurl = logoutsuccssurl;
    }

    public String getPermitall() {
        return permitall;
    }

    public void setPermitall(String permitall) {
        this.permitall = permitall;
    }

    public String getDeniedpage() {
        return deniedpage;
    }

    public void setDeniedpage(String deniedpage) {
        this.deniedpage = deniedpage;
    }

    public String getUrlroles() {
        return urlroles;
    }

    public void setUrlroles(String urlroles) {
        this.urlroles = urlroles;
    }

}
