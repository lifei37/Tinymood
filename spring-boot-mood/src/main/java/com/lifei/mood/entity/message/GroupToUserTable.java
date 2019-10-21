package com.lifei.mood.entity.message;

import java.util.Date;

public class GroupToUserTable {
    private Integer gtuId;
    private Integer gtuGroupId;
    private Integer gtuUserId;
    private String gtuNickName;
    private Date gtuCreateTime;

    public void setGtuId(Integer gtuId) {
        this.gtuId = gtuId;
    }

    public void setGtuGroupId(Integer gtuGroupId) {
        this.gtuGroupId = gtuGroupId;
    }

    public void setGtuUserId(Integer gtuUserId) {
        this.gtuUserId = gtuUserId;
    }

    public void setGtuNickName(String gtuNickName) {
        this.gtuNickName = gtuNickName;
    }

    public void setGtuCreateTime(Date gtuCreateTime) {
        this.gtuCreateTime = gtuCreateTime;
    }

    public Integer getGtuId() {
        return gtuId;
    }

    public Integer getGtuGroupId() {
        return gtuGroupId;
    }

    public Integer getGtuUserId() {
        return gtuUserId;
    }

    public String getGtuNickName() {
        return gtuNickName;
    }

    public Date getGtuCreateTime() {
        return gtuCreateTime;
    }
}
