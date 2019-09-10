package com.spboot.pojo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author feifei
 * @Classname Role
 * @Description TODO
 * @Date 2019/9/10 15:26
 * @Created by 陈群飞
 */
@Document
public class Role implements Serializable {

    private Long id;
    @Field("role_name")
    private String roleName=null;
    private String note=null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
