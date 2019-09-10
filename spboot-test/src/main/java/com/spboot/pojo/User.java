package com.spboot.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * @author feifei
 * @Classname User
 * @Description TODO
 * @Date 2019/9/10 15:23
 * @Created by 陈群飞
 */
@Document
public class User implements Serializable {
    @Id
    private Long id;
    @Field("user_name")
    private String userName=null;
    private String note=null;

    private List<Role> roles=null;

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
