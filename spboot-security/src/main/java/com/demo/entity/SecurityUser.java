package com.demo.entity;

import com.demo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author feifei
 * @Classname SecurityUser
 * @Description TODO
 * @Date 2019/7/26 10:52
 * @Created by ChenS
 */
public class SecurityUser extends User implements UserDetails {

    private static final long serialVersionUID = 1L;
    public SecurityUser(User user) {
        if(user != null)
        {
            this.setId(user.getId());
            this.setName(user.getName());
//            this.setEmail(user.getEmail());
//            this.setPassword(user.getPassword());
//            this.setSex(user.getSex());
//            this.setCreatedate(user.getCreatedate());
//            this.setRoles(user.getRoles());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        List<Role> roles = this.getRoles();
//        if(roles != null)
//        {
//            for (Role role : roles) {
//                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
//                authorities.add(authority);
//            }
//        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
