package com.baizhi.controller;

import com.baizhi.entity.Manager;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DELL on 2018/1/10.
 */
@Controller
@RequestMapping("menu")
public class MenuController {
    @Resource
    private MenuService menuService;
    @RequestMapping("queryAll")
    @ResponseBody
    public List<Menu> queryAll(HttpSession session){
        Manager manager = (Manager) session.getAttribute("login");
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory();
        SecurityManager instance = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(instance);


        Subject subject = SecurityUtils.getSubject();

        if(subject.isAuthenticated()){

            System.out.println(subject.hasRole("role2"));
            System.out.println(subject.hasAllRoles(Arrays.asList("role1","role2")));

            System.out.println(subject.isPermitted("product:update"));

        }
        List<Menu> list=null;
        if(subject.hasRole("root")){
             list =menuService.selectByRole("root");
        }else if(subject.hasRole("admin")){
            list =menuService.selectByRole("admin");
        }else if(subject.hasRole("user")){
            list =menuService.selectByRole("user");
        }
        return list;
    }
}

