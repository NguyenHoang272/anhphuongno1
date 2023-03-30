package com.project.be.payload.response;

public class UserInfomartion {

    private String username;

    private String avatar;

    private String lastName;

    private String userId;

    public UserInfomartion() {
    }

    public UserInfomartion(String username, String avatar, String lastName) {
        this.username = username;
        this.avatar = avatar;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
