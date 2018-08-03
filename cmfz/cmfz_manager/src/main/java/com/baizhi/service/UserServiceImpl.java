package com.baizhi.service;

import com.baizhi.annotation.Detail;
import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.util.MD5Util;
import com.baizhi.util.POIUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by DELL on 2018/1/12.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;
    @Override
    @Detail
    public User selectOne(String mobilephone) {
        return userDAO.queryOneByMobilephone(mobilephone);
    }

    @Override
    @Detail
    public List<User> selectAll(Integer page, Integer rows) {
        Integer pageStart = (page-1) * rows;

        return userDAO.queryAll(pageStart,rows);
    }
    @Override
    @Detail("adds")
    public Workbook export()  {
        // TODO Auto-generated method stub
        List<User> users = userDAO.queryAll(0,100);
        Workbook workbook = POIUtil.export(users,User.class);
        return workbook;
    }
    @Override
    @Detail("adds")
    public void addUsers(List<User> users) {

        for (User user:users) {
            user.setU_id(UUID.randomUUID().toString());
            user.setC_state(true);
            user.setRegistdate(new Date());
            user.setSalt(MD5Util.getSalt(5));
        }

        userDAO.insertUsers(users);
    }


    @Override
    @Detail("delete")
    public void dropUser(String p_id) {
        userDAO.deleteUser(p_id);
    }

    @Override
    @Detail("update")
    public void changeUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Detail
    public Integer selectTotalCount() {
        return userDAO.queryTotalCount();
    }

    @Override
    @Detail
    public void login(User user) {

    }
}
