package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DELL on 2018/1/14.
 */
public class Log implements Serializable{
    private String l_id;
    private String username;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    private String detail;
    private String type;

    public String getL_id() {
        return l_id;
    }

    public String getUsername() {
        return username;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getDetail() {
        return detail;
    }

    public String getType() {
        return type;
    }

    public void setL_id(String l_id) {
        this.l_id = l_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Log() {
    }

    public Log(String l_id, String username, Date createDate, String detail, String type) {
        this.l_id = l_id;
        this.username = username;
        this.createDate = createDate;
        this.detail = detail;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Log{" +
                "l_id='" + l_id + '\'' +
                ", username='" + username + '\'' +
                ", createDate=" + createDate +
                ", detail='" + detail + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
