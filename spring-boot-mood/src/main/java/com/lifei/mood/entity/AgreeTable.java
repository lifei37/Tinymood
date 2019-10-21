package com.lifei.mood.entity;

import java.io.Serializable;
import java.util.Date;

public class AgreeTable implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer essayId;
    private Integer isActive;
    private Date addTime;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getEssayId() {
        return essayId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public Date getAddTime() {
        return addTime;
    }
}
