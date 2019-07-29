package com.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author feifei
 * @Classname DepartMent
 * @Description TODO
 * @Date 2019/7/26 16:44
 * @Created by ChenS
 */
public class DepartMent implements Serializable {

    private Long id;
    private String name;
    private Date creteDate;

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

    public Date getCreteDate() {
        return creteDate;
    }

    public void setCreteDate(Date creteDate) {
        this.creteDate = creteDate;
    }
}
