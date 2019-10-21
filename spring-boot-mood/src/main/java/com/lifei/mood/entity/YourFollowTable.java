package com.lifei.mood.entity;

import java.util.Date;
import java.util.List;

public class YourFollowTable {
    private int aId;
    private int aUserId;
    private int aFollowUserId;
    private Date aFollowTime;
    private UserInfo user;
    private List<InformalEssay> essay;

    public void setEssay(List<InformalEssay> essay) {
        this.essay = essay;
    }

    public List<InformalEssay> getEssay() {
        return essay;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public void setaUserId(int aUserId) {
        this.aUserId = aUserId;
    }

    public void setaFollowUserId(int aFollowId) {
        this.aFollowUserId = aFollowId;
    }

    public void setaFollowTime(Date aFllowTime) {
        this.aFollowTime = aFllowTime;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public int getaId() {
        return aId;
    }

    public int getaUserId() {
        return aUserId;
    }

    public int getaFollowUserId() {
        return aFollowUserId;
    }

    public Date getaFollowTime() {
        return aFollowTime;
    }

    public UserInfo getUser() {
        return user;
    }
}
