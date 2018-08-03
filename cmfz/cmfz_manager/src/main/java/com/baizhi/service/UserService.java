package com.baizhi.service;


import com.baizhi.entity.User;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * Created by DELL on 2018/1/10.
 */
public interface UserService {
    User selectOne(String mobilephone);
    List<User> selectAll(Integer page, Integer rows);
    void addUsers(List<User> users);
    void dropUser(String p_id);
    void changeUser(User user);
    Integer selectTotalCount();
    void login(User user);
    Workbook export();
}
