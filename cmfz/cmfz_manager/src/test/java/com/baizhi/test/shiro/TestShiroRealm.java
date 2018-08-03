package com.baizhi.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by DELL on 2018/1/22.
 */
public class TestShiroRealm {
    public static void main(String[] args) {

        //创建安全管理器
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro/shiro-realm.ini");
        //获取安全管理
        SecurityManager instance = iniSecurityManagerFactory.getInstance();
        //注入安全工具类
        SecurityUtils.setSecurityManager(instance);
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(new UsernamePasswordToken("zhangsan", "123456"));
        } catch (AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(subject.isAuthenticated());


    }
}
