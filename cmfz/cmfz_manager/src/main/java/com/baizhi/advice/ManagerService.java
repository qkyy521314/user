package com.baizhi.advice;

import com.baizhi.entity.Manager;

import javax.servlet.http.HttpSession;

/**
 * Created by DELL on 2018/1/10.
 */

public interface ManagerService {
    void login(Manager manager, HttpSession session);
    void register(Manager manager);
}
