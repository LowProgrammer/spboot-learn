package com.demo.model;

/**
 * @author feifei
 * @Classname UserRoles
 * @Description TODO
 * @Date 2019/7/26 17:08
 * @Created by ChenS
 */
public class UserRoles {
    private Integer id;
    private User userId;
    private Role roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }
}
