package com.lifei.mood.entity.message;

import com.lifei.mood.entity.UserInfo;

import java.util.Date;

public class PersonMessageTable {
    private Integer mId;
    private String mMessage;
    private String mStatus;
    private Integer mFromUserId;
    private Integer mToUserId;
    private Date mSenTime;
    private Integer mMessageTypeId;
    private UserInfo user;

    public void setUser(UserInfo users) {
        this.user = users;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public void setmFromUserId(Integer mFromUserId) {
        this.mFromUserId = mFromUserId;
    }

    public void setmToUserId(Integer mToUserId) {
        this.mToUserId = mToUserId;
    }

    public void setmSenTime(Date mSenTime) {
        this.mSenTime = mSenTime;
    }

    public void setmMessageTypeId(Integer mMessageTypeId) {
        this.mMessageTypeId = mMessageTypeId;
    }

    public Integer getmId() {
        return mId;
    }

    public String getmMessage() {
        return mMessage;
    }

    public String getmStatus() {
        return mStatus;
    }

    public Integer getmFromUserId() {
        return mFromUserId;
    }

    public Integer getmToUserId() {
        return mToUserId;
    }

    public Date getmSenTime() {
        return mSenTime;
    }

    public Integer getmMessageTypeId() {
        return mMessageTypeId;
    }
}
