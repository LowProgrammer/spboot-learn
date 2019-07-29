package com.spboot.learn.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author feifei
 * @Classname User
 * @Description TODO
 * @Date 2019/7/29 15:12
 * @Created by ChenS
 */
@Component("user")
public class User {
    @Value("1")
    private Long id;
    @Value("user_name_1")
    private String userName;
    @Value("note_1")
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
