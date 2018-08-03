package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

/**
 * Created by DELL on 2018/1/10.
 */
public interface MenuService {
    Menu selectOne(Integer m_id);
    List<Menu> selectAll();
    List<Menu> selectByRole(String name);
    void addMenu(Menu menu);
    void dropMenu(Integer m_id);
    void changeMenu(Menu menu);
}
