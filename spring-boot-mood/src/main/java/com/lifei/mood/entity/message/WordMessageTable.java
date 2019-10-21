package com.lifei.mood.entity.message;

import com.lifei.mood.entity.UserInfo;

import java.util.Date;

public class WordMessageTable {
    private Integer wmId;
    private String wmMessage;
    private String wmStatus;
    private Integer wmFromUserId;
    private Date wmSenTime;
    private Integer wmMessageTypeId;
    private UserInfo user;

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setWmId(Integer wmId) {
        this.wmId = wmId;
    }

    public void setWmMessage(String wmMessage) {
        this.wmMessage = wmMessage;
    }

    public void setWmStatus(String wmStatus) {
        this.wmStatus = wmStatus;
    }

    public void setWmFromUserId(Integer wmFromUserId) {
        this.wmFromUserId = wmFromUserId;
    }

    public void setWmSenTime(Date wmSenTime) {
        this.wmSenTime = wmSenTime;
    }

    public void setWmMessageTypeId(Integer wmMessageTypeId) {
        this.wmMessageTypeId = wmMessageTypeId;
    }

    public Integer getWmId() {
        return wmId;
    }

    public String getWmMessage() {
        return wmMessage;
    }

    public String getWmStatus() {
        return wmStatus;
    }

    public Integer getWmFromUserId() {
        return wmFromUserId;
    }

    public Date getWmSenTime() {
        return wmSenTime;
    }

    public Integer getWmMessageTypeId() {
        return wmMessageTypeId;
    }
}
