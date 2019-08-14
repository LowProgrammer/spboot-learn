package com.spboot.db.pojo;

import com.spboot.db.enums.SexEnum;
import org.apache.ibatis.type.Alias;

/**
 * @author feifei
 * @Classname User
 * @Description TODO
 * @Date 2019/8/13 13:29
 * @Created by ChenS
 */
@Alias(value = "user")
public class User {
    private Long id=null;
    private String username=null;
    private SexEnum sex=null;
    private String note=null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
