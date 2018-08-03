package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2018/1/10.
 */
public class Menu implements Serializable{
    private Integer m_id;
    private String text;
    private Integer parent_id;
    private List<Menu> menus;
    private String href;
    private String iconCls;

    public Integer getM_id() {
        return m_id;
    }

    public String getText() {
        return text;
    }

    public String getHref() {
        return href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Menu() {
    }

    public Menu(Integer m_id, String text, Integer parent_id, List<Menu> menus, String href, String iconCls) {
        this.m_id = m_id;
        this.text = text;
        this.parent_id = parent_id;
        this.menus = menus;
        this.href = href;
        this.iconCls = iconCls;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "m_id=" + m_id +
                ", text='" + text + '\'' +
                ", parent_id=" + parent_id +
                ", menus=" + menus +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                '}';
    }
}
