package com.project.be.payload.response;

import com.project.be.model.account.Account;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtRespone {

    private String token;
    private String type = "Bearer";
    private UserInfomartion userInfomartion;
    private Collection<? extends GrantedAuthority> roles;

    public JwtRespone() {
    }

    public JwtRespone(String token,
                      UserInfomartion userInfomartion,
                      Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.userInfomartion = userInfomartion;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserInfomartion getUserInfomartion() {
        return userInfomartion;
    }

    public void setUserInfomartion(UserInfomartion userInfomartion) {
        this.userInfomartion = userInfomartion;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
