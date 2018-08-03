package com.baizhi.dao;

import com.baizhi.entity.Manager;

/**
 * Created by DELL on 2018/1/10.
 */
public interface ManagerDAO {
    Manager queryOneByName(String  name);
    Manager queryOneByNameRole(String name);
    Manager queryOne(Integer m_id);
    void insertManager(Manager manager);
    void updateManager(Manager manager);
    void deleteManager(Integer m_id);
}
