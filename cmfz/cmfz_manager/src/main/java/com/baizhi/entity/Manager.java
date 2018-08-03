package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2018/1/10.
 */
public class Manager implements Serializable{
    private Integer m_id;
    private String name;
    private String password;
    private Integer jurisdiction;
    private Boolean m_state;
    private String m_salt;
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getM_id() {
        return m_id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Integer getJurisdiction() {
        return jurisdiction;
    }

    public Boolean getM_state() {
        return m_state;
    }

    public String getM_salt() {
        return m_salt;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJurisdiction(Integer jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public void setM_state(Boolean m_state) {
        this.m_state = m_state;
    }

    public void setM_salt(String m_salt) {
        this.m_salt = m_salt;
    }

    public Manager() {
    }

    public Manager(Integer m_id, String name, String password, Integer jurisdiction, Boolean m_state, String m_salt, List<Role> roles) {
        this.m_id = m_id;
        this.name = name;
        this.password = password;
        this.jurisdiction = jurisdiction;
        this.m_state = m_state;
        this.m_salt = m_salt;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "m_id=" + m_id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", jurisdiction=" + jurisdiction +
                ", m_state=" + m_state +
                ", m_salt='" + m_salt + '\'' +
                ", roles=" + roles +
                '}';
    }
}
