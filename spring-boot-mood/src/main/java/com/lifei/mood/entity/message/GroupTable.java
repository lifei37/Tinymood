package com.lifei.mood.entity.message;

import java.util.Date;

public class GroupTable {
    private Integer gId;
    private String gName;
    private Date gCreateTime;
    private Integer gAdmin;
    private String gNotice;
    private String gIntro;

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public void setgCreateTime(Date gCreateTime) {
        this.gCreateTime = gCreateTime;
    }

    public void setgAdmin(Integer gAdmin) {
        this.gAdmin = gAdmin;
    }

    public void setgNotice(String gNotice) {
        this.gNotice = gNotice;
    }

    public void setgIntro(String gIntro) {
        this.gIntro = gIntro;
    }

    public Integer getgId() {
        return gId;
    }

    public String getgName() {
        return gName;
    }

    public Date getgCreateTime() {
        return gCreateTime;
    }

    public Integer getgAdmin() {
        return gAdmin;
    }

    public String getgNotice() {
        return gNotice;
    }

    public String getgIntro() {
        return gIntro;
    }
}
