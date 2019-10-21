package com.lifei.mood.entity.message;


import java.util.Date;

public class GroupMessageTable {
    private Integer gmId;
    private Integer gmUserId;
    private String content;
    private String gmNickName;
    private Date gmCreateTime;

    public void setGmId(Integer gmId) {
        this.gmId = gmId;
    }

    public void setGmUserId(Integer gmUserId) {
        this.gmUserId = gmUserId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setGmNickName(String gmNickName) {
        this.gmNickName = gmNickName;
    }

    public void setGmCreateTime(Date gmCreateTime) {
        this.gmCreateTime = gmCreateTime;
    }

    public Integer getGmId() {
        return gmId;
    }

    public Integer getGmUserId() {
        return gmUserId;
    }

    public String getContent() {
        return content;
    }

    public String getGmNickName() {
        return gmNickName;
    }

    public Date getGmCreateTime() {
        return gmCreateTime;
    }
}
