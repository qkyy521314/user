package com.baizhi.dao;

import com.baizhi.entity.Menu;

import java.util.List;

/**
 * Created by DELL on 2018/1/10.
 */
public interface MenuDAO {
    Menu queryOne(Integer m_id);
    List<Menu> queryByRole(String role_name);
    List<Menu> queryAll();
    void insertMenu(Menu menu);
    void updateMenu(Menu menu);
    void deleteMenu(Integer m_id);
}
