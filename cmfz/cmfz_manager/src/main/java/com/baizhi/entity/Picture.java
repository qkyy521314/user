package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by DELL on 2018/1/10.
 */
public class Picture implements Serializable {
    private String p_id;
    private String p_name;
    private String p_url;
    private Boolean p_state;
    private String html_url;

    public String getP_id() {
        return p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public String getP_url() {
        return p_url;
    }

    public Boolean getP_state() {
        return p_state;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public void setP_url(String p_url) {
        this.p_url = p_url;
    }

    public void setP_state(Boolean p_state) {
        this.p_state = p_state;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public Picture() {
    }

    public Picture(String p_id, String p_name, String p_url, Boolean p_state, String html_url) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_url = p_url;
        this.p_state = p_state;
        this.html_url = html_url;
    }

    @Override
    public String toString() {
        return "PictureDAO{" +
                "p_id='" + p_id + '\'' +
                ", p_name='" + p_name + '\'' +
                ", p_url='" + p_url + '\'' +
                ", p_state=" + p_state +
                ", html_url='" + html_url + '\'' +
                '}';
    }
}
