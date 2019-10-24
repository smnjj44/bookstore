package com.springboot.bookstore.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Manager implements UserDetails {
    private int id;
    private String name;
    private String password;
    //权限角色字段
    private String auth;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] authorities = auth.split(",");
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (String auth : authorities) {
            authorityList.add(new SimpleGrantedAuthority(auth));
        }
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthority(String auth) {
        this.auth = auth;
    }

    public String getAuthority() {
        return auth;
    }
}
