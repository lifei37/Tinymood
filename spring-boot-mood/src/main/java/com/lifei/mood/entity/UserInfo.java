package com.lifei.mood.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class UserInfo implements Serializable {
    private int id;
    private String userName;
    private String password;
    private Date addTime;
    private String avatar;
    private String desc;
    private String phone;
    private String address;
    private String nickName;
    private String sex;
    private Date birthday;

    public UserInfo(int id, String userName, String password, Date addTime, String avatar, String desc, String phone, String address, String nickName, String sex, Date birthday) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.addTime = addTime;
        this.avatar = avatar;
        this.desc = desc;
        this.phone = phone;
        this.address = address;
        this.nickName = nickName;
        this.sex = sex;
        this.birthday = birthday;
    }

    public UserInfo() {
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Date getAddTime() {
        return addTime;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getDesc() {
        return desc;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
