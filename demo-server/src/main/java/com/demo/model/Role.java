package com.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author feifei
 * @Classname Role
 * @Description TODO
 * @Date 2019/7/26 16:48
 * @Created by ChenS
 */
public class Role implements Serializable {

    private Long id;
    private String name;
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date creteDate) {
        this.createDate = creteDate;
    }
}
