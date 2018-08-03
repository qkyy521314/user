package com.baizhi.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class TestShiroMd5Realm {
	public static void main(String[] args) {
		
		
		IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro/shiro-md5-realm.ini");
		
		SecurityManager instance = iniSecurityManagerFactory.getInstance();
		
		SecurityUtils.setSecurityManager(instance);
		
		
		Subject subject = SecurityUtils.getSubject();
		
		
		try {
			subject.login(new UsernamePasswordToken("zhangsan", "123456"));
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		System.out.println(subject.isAuthenticated());
		
	}

}
