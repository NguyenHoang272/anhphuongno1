package com.project.be.model.account;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.be.model.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private Integer deleteStatus;

    private Integer lockStatus;

    @JsonManagedReference
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Set<AccountRole> accountRoleSet;

    @JsonBackReference
    @OneToOne(mappedBy = "account")
    private User user;

    public Account() {
    }

    public Account(Integer id, String username, String password, Integer deleteStatus, Integer lockStatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.deleteStatus = deleteStatus;
        this.lockStatus = lockStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }

    public Set<AccountRole> getAccountRoleSet() {
        return accountRoleSet;
    }

    public void setAccountRoleSet(Set<AccountRole> accountRoleSet) {
        this.accountRoleSet = accountRoleSet;
    }

    public User getUser() {
        return user;
    }

    public void setUserSet(User user) {
        this.user = user;
    }
}
