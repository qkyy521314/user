package com.baizhi.service;

import com.baizhi.annotation.Detail;
import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Menu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by DELL on 2018/1/10.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDAO menuDAO;
    @Override
    @Detail
    public Menu selectOne(Integer m_id) {
        return menuDAO.queryOne(m_id);
    }

    @Override
    @Detail
    public List<Menu> selectAll() {
        return menuDAO.queryAll();
    }

    @Override
    @Detail
    public List<Menu> selectByRole(String name) {
        return menuDAO.queryByRole(name);
    }

    @Override
    @Detail("add")
    public void addMenu(Menu menu) {
        menuDAO.insertMenu(menu);
    }

    @Override
    @Detail("delete")
    public void dropMenu(Integer m_id) {
        menuDAO.deleteMenu(m_id);
    }

    @Override
    @Detail("update")
    public void changeMenu(Menu menu) {
        menuDAO.updateMenu(menu);
    }
}
