package com.baizhi.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

/**
 * 测试授权
 * @author Administrator
 *
 */
public class TestAuthenticationAndAuthorization {

	public static void main(String[] args) {
		
		
		IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory();
		SecurityManager instance = iniSecurityManagerFactory.getInstance();
		SecurityUtils.setSecurityManager(instance);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(new UsernamePasswordToken("zhangsan", "123456"));
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		if(subject.isAuthenticated()){
			
			System.out.println(subject.hasRole("role2"));
			System.out.println(subject.hasAllRoles(Arrays.asList("role1","role2")));

			System.out.println(subject.isPermitted("product:update"));
			
		}
		

		
		/***
		 * 1.设计权限模型
		 * 2.完成数据库调用
		 * 	 用户认证授权  jdbc  mybatis
		 */
		
	}
	
}
