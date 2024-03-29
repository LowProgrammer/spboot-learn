package com.spboot.redis.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author feifei
 * @Classname User
 * @Description TODO
 * @Date 2019/9/5 10:57
 * @Created by 陈群飞
 */
@Alias("user")
public class User implements Serializable {

    private static final long serialVersionUID=23165331161166461L;
    private Long id;
    private String userName;
    private String note;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
