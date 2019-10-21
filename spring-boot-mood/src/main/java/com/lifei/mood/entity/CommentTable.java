package com.lifei.mood.entity;

import java.io.Serializable;
import java.util.Date;

public class CommentTable implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer essayId;
    private String comment;
    private Integer parentCommentId;
    private Date addTime;
    private UserInfo user;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public void setUser(UserInfo user) {
        this.user = user;
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

    public String getComment() {
        return comment;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public UserInfo getUser() {
        return user;
    }
}
