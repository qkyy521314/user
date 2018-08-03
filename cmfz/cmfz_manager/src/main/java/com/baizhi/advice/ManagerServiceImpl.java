package com.baizhi.advice;

import com.baizhi.annotation.Detail;
import com.baizhi.dao.ManagerDAO;
import com.baizhi.entity.Manager;
import com.baizhi.util.MD5Util;
import com.baizhi.util.MD5Util_Shiro;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by DELL on 2018/1/10.
 */

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private ManagerDAO managerDAO;
    @Override
    @Detail("login")
    public void login(Manager manager, HttpSession session) {
        session.setAttribute("login",manager);
        //根据用户名密码 认证用户  怎么认证     在web环境下 当配置shiroFitlerFactoryBean 并注入 安全管理器后   自动将安全管理器注入到安全工具类中
        //获取主体对象进行认证
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(manager.getName(), manager.getPassword()));


//        Manager m = managerDAO.queryOneByName(manager.getName());
//        if(m==null)throw new RuntimeException("用户不存在");
//
//        if(!MD5Util.jdkMD(manager.getPassword()+m.getM_salt()).equals(m.getPassword()))
//            throw new RuntimeException("用户密码错误");


    }

    @Override
    @Detail("regist")
    public void register(Manager manager) {
        String salt = MD5Util.getSalt(4);
        manager.setM_salt(salt);
        String password = MD5Util_Shiro.shiroMD5(manager.getPassword(),salt);
        manager.setPassword(password);

        managerDAO.insertManager(manager);

    }
}
