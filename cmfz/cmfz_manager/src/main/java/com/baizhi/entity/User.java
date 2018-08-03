package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DELL on 2018/1/12.
 */
public class User implements Serializable {
    private String u_id;
    private String mobilephone;
    private String password;
    private String head_portrait;
    private String b_name;//法名
    private String username;
    private String address;
    private String signature;
    private Boolean c_state;
    private Integer age;
    private String u_ip;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date registdate;
    private String salt;

    public String getU_id() {
        return u_id;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getPassword() {
        return password;
    }

    public String getHead_portrait() {
        return head_portrait;
    }

    public String getB_name() {
        return b_name;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getSignature() {
        return signature;
    }

    public Boolean getC_state() {
        return c_state;
    }

    public Integer getAge() {
        return age;
    }

    public String getU_ip() {
        return u_ip;
    }

    public Date getRegistdate() {
        return registdate;
    }

    public String getSalt() {
        return salt;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHead_portrait(String head_portrait) {
        this.head_portrait = head_portrait;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setC_state(Boolean c_state) {
        this.c_state = c_state;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setU_ip(String u_ip) {
        this.u_ip = u_ip;
    }

    public void setRegistdate(Date registdate) {
        this.registdate = registdate;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User() {
    }

    public User(String u_id, String mobilephone, String password, String head_portrait, String b_name, String username, String address, String signature, Boolean c_state, Integer age, String u_ip, Date registdate, String salt) {
        this.u_id = u_id;
        this.mobilephone = mobilephone;
        this.password = password;
        this.head_portrait = head_portrait;
        this.b_name = b_name;
        this.username = username;
        this.address = address;
        this.signature = signature;
        this.c_state = c_state;
        this.age = age;
        this.u_ip = u_ip;
        this.registdate = registdate;
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id='" + u_id + '\'' +
                ", mobilephone='" + mobilephone + '\'' +
                ", password='" + password + '\'' +
                ", head_portrait='" + head_portrait + '\'' +
                ", b_name='" + b_name + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", signature='" + signature + '\'' +
                ", c_state='" + c_state + '\'' +
                ", age=" + age +
                ", u_ip='" + u_ip + '\'' +
                ", registdate=" + registdate +
                ", salt='" + salt + '\'' +
                '}';
    }
}
