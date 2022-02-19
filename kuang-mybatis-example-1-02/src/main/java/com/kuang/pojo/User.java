package com.kuang.pojo;

import org.apache.ibatis.type.Alias;

/**
 * @author John Chen
 * @Date 202202
 */

@Alias("user")
public class User {
    private int userId;
    private String userName;
    private  String password;

    public User() {
    }

    public User(int id, String name, String pwd) {
        this.userId = id;
        this.userName = name;
        this.password = pwd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", name='" + userName + '\'' +
                ", pwd='" + password + '\'' +
                '}';
    }
}
