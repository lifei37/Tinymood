package com.lifei.mood.entity.message;

public class GroupMessageToUser {
    private Integer gmId;
    private Integer gmUserId;
    private Integer gmGroupId;
    private Integer gmMessageId;
    private String gmStatus;

    public void setGmId(Integer gmId) {
        this.gmId = gmId;
    }

    public void setGmUserId(Integer gmUserId) {
        this.gmUserId = gmUserId;
    }

    public void setGmGroupId(Integer gmGroupId) {
        this.gmGroupId = gmGroupId;
    }

    public void setGmMessageId(Integer gmMessageId) {
        this.gmMessageId = gmMessageId;
    }

    public void setGmStatus(String gmStatus) {
        this.gmStatus = gmStatus;
    }

    public Integer getGmId() {
        return gmId;
    }

    public Integer getGmUserId() {
        return gmUserId;
    }

    public Integer getGmGroupId() {
        return gmGroupId;
    }

    public Integer getGmMessageId() {
        return gmMessageId;
    }

    public String getGmStatus() {
        return gmStatus;
    }
}
