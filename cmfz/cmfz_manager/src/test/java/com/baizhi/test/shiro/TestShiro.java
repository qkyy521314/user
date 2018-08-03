package com.baizhi.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by DELL on 2018/1/22.
 * 1.创建realm文件(定义本地文件)xxx.ini
 * 2.创建securityManager
 * 3.创建token令牌
 * 4.Subject携带token发起认证
 */
public class TestShiro {
    public static void main(String[] args) {

        //创建安全管理器工厂
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro/shiro.ini");
        //安全管理器
        SecurityManager instance = iniSecurityManagerFactory.getInstance();


        //安全工具类认证需要安全管理器
        SecurityUtils.setSecurityManager(instance);
        //从安全工具类中获取一个主体对象
        Subject subject = SecurityUtils.getSubject();

        //认证
        try {
            subject.login(new UsernamePasswordToken("zhangsan", "123456"));
        } catch (UnknownAccountException e) {
            System.out.println("用户名错误");

        }catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
        }
        /**
         * org.apache.shiro.authc.UnknownAccountException :  用户名错误
         * org.apache.shiro.authc.IncorrectCredentialsException : 密码错误
         *
         */
        //获取当前主体的人证状态
        System.out.println(subject.isAuthenticated());
        //退出
        subject.logout();
        System.out.println(subject.isAuthenticated());


		/*
		Realm realm;

		Authenticator authenticator;

		CredentialsMatcher credentialsMatcher;*/

        /***
         * 1.完成用户名的认证AuthenticatingRealm 必须实现doGetAuthenticationInfo  在这个方法中只完成用户名的认证
         * 2.完成密码的人是在AuthenticatingRealm 类中getAuthenticationInfo的方法完成的
         * 		AuthenticatingRealm 一定要使用凭证匹配器  默认使用凭证匹配器SimpleCredentialsMatcher
         *
         *
         */




    }
}
