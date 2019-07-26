package com.demo.model;

import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Date 2019/7/24 17:51
 * @Created by ChenS
 */
public class User implements Serializable {
    private static final long serialVersionUID = -3946734305303957850L;

    private Long id;
    private String name;
    private Integer age;
    private String password;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{name:" + name + ",age:" + age + "}";
    }
}
