package com.lifei.mood.entity.message;

import com.lifei.mood.entity.UserInfo;

import java.util.Date;

public class FriendsTable {
    private Integer fId;
    private Integer fUserId;
    private Integer fFriendId;
    private String fNickName;
    private Date fAddTime;

    public void setfAddTime(Date fAddTime) {
        this.fAddTime = fAddTime;
    }

    public Date getfAddTime() {
        return fAddTime;
    }

    private UserInfo user;


    public FriendsTable() {
    }

    public FriendsTable(Integer fId, Integer fUserId, Integer fFriendId, String fNickName, UserInfo user) {
        this.fId = fId;
        this.fUserId = fUserId;
        this.fFriendId = fFriendId;
        this.fNickName = fNickName;
        this.user = user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public void setfUserId(Integer fUserId) {
        this.fUserId = fUserId;
    }

    public void setfFriendId(Integer fFriendId) {
        this.fFriendId = fFriendId;
    }

    public void setfNickName(String fNickName) {
        this.fNickName = fNickName;
    }

    public Integer getfId() {
        return fId;
    }

    public Integer getfUserId() {
        return fUserId;
    }

    public Integer getfFriendId() {
        return fFriendId;
    }

    public String getfNickName() {
        return fNickName;
    }
}
