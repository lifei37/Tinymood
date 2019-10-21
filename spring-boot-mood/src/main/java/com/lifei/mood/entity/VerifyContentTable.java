package com.lifei.mood.entity;

import java.util.Date;

public class VerifyContentTable {
    private Integer vId;
    private Integer vUserId;
    private Integer vCollectUserId;
    private Date vSendTime;
    private String vSendContent;
    private UserInfo user;

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public void setvUserId(Integer vUserId) {
        this.vUserId = vUserId;
    }

    public void setvCollectUserId(Integer vCollectUserId) {
        this.vCollectUserId = vCollectUserId;
    }

    public void setvSendTime(Date vSendTime) {
        this.vSendTime = vSendTime;
    }

    public void setvSendContent(String vSendContent) {
        this.vSendContent = vSendContent;
    }

    public Integer getvId() {
        return vId;
    }

    public Integer getvUserId() {
        return vUserId;
    }

    public Integer getvCollectUserId() {
        return vCollectUserId;
    }

    public Date getvSendTime() {
        return vSendTime;
    }

    public String getvSendContent() {
        return vSendContent;
    }
}
