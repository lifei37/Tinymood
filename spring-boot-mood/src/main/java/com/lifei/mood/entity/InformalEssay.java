package com.lifei.mood.entity;


import java.io.Serializable;
import java.util.Date;

public class InformalEssay implements Serializable {
    private Integer id;
    private Integer userId;
    private String content;
    private Integer agreeNums;
    private Integer commentNums;
    private Date publishTime;
    private String picture;
    private String publishAddress;
    private String isVisible;
    private UserInfo user;

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setIsVisible(String isVisible){
        this.isVisible = isVisible;
    }

    public String getIsVisible(){
        return isVisible;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAgreeNums(Integer agreeNums) {
        this.agreeNums = agreeNums;
    }

    public void setCommentNums(Integer commentNums) {
        this.commentNums = commentNums;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setPublishAddress(String publishAddress) {
        this.publishAddress = publishAddress;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public Integer getAgreeNums() {
        return agreeNums;
    }

    public Integer getCommentNums() {
        return commentNums;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public String getPicture() {
        return picture;
    }

    public String getPublishAddress() {
        return publishAddress;
    }
}
