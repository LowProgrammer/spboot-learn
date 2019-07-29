package com.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private Date creteDate;
    private Integer sex;
    private String email;
    private DepartMent departMent;
    private Set<Role> userRoles=new HashSet<>();

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

    public Date getCretedate() {
        return creteDate;
    }

    public void setCretedate(Date cretedate) {
        this.creteDate = cretedate;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DepartMent getDepartMent() {
        return departMent;
    }

    public void setDepartMent(DepartMent departMent) {
        this.departMent = departMent;
    }

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer("role:{");
        //Role[] role1=(Role[]) userRoles.toArray();
//        for(Role role:role1){
//            sb.append("{ name:"+role.getName()+",createDate:"+role.getCreateDate()+"},");
//        }
//        sb.append("}");
        return "User{name:" + name + ",age:" + age + ",emaile:"+email+",sex:"+sex+",createDate:"+creteDate+",departMent:"+departMent.getName()+","+sb+"}";
    }
}
