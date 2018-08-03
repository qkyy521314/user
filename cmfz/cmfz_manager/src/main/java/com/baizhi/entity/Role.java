package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by DELL on 2018/1/26.
 */
public class Role implements Serializable {
    private Integer id;
    private String role_name;
    private String role_tag;
    private Boolean role_status;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", role_tag='" + role_tag + '\'' +
                ", role_status=" + role_status +
                '}';
    }

    public Role() {
    }

    public Role(Integer id, String role_name, String role_tag, Boolean role_status) {
        this.id = id;
        this.role_name = role_name;
        this.role_tag = role_tag;
        this.role_status = role_status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public void setRole_tag(String role_tag) {
        this.role_tag = role_tag;
    }

    public void setRole_status(Boolean role_status) {
        this.role_status = role_status;
    }

    public Integer getId() {
        return id;
    }

    public String getRole_name() {
        return role_name;
    }

    public String getRole_tag() {
        return role_tag;
    }

    public Boolean getRole_status() {
        return role_status;
    }
}
