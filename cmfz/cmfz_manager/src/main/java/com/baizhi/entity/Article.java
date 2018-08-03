package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DELL on 2018/1/16.
 */
public class Article implements Serializable{
    private String a_id;
    private String title;
    private String author;
    private String illustration;//插图
    private String particulars;//文章详情
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date publish_date;
    private Boolean a_state;
    private String html_url;

    public String getA_id() {
        return a_id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIllustration() {
        return illustration;
    }

    public String getParticulars() {
        return particulars;
    }


    public Date getPublish_date() {
        return publish_date;
    }

    public Boolean getA_state() {
        return a_state;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }


    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public void setA_state(Boolean a_state) {
        this.a_state = a_state;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public Article() {
    }

    public Article(String a_id, String title, String author, String illustration, String particulars, Date publish_date, Boolean a_state, String html_url) {
        this.a_id = a_id;
        this.title = title;
        this.author = author;
        this.illustration = illustration;
        this.particulars = particulars;
        this.publish_date = publish_date;
        this.a_state = a_state;
        this.html_url = html_url;
    }

    @Override
    public String toString() {
        return "Article{" +
                "a_id='" + a_id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", illustration='" + illustration + '\'' +
                ", particulars='" + particulars + '\'' +
                ", publish_date=" + publish_date +
                ", a_state=" + a_state +
                ", html_url='" + html_url + '\'' +
                '}';
    }
}
