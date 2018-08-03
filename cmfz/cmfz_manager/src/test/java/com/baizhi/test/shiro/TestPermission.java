package com.baizhi.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;

/**
 * 测试授权
 * @author Administrator
 *
 */
public class TestPermission {

	public static void main(String[] args) {

		//认证
		IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro/shiro-permission.ini");
		SecurityManager instance = iniSecurityManagerFactory.getInstance();
		SecurityUtils.setSecurityManager(instance);
		Subject subject = SecurityUtils.getSubject();
		
		try {
			subject.login(new UsernamePasswordToken("lisi", "123456"));
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//授权
		if(subject.isAuthenticated()){
			
			//基于角色访问控制
			/*boolean hasRole = subject.hasRole("role1");
			System.out.println(hasRole);
			//同时拥有这个两个角色
			boolean hasAllRoles = subject.hasAllRoles(Arrays.asList("role1","role3"));
			System.out.println(hasAllRoles);
			//分别具有那些角色
			boolean[] hasRoles = subject.hasRoles(Arrays.asList("role1","role3"));
			for (boolean b : hasRoles) {
				System.out.println(b);
			}*/
			
			//基于资源的访问控制
			boolean permitted = subject.isPermitted("product:findAll:001");
			System.out.println(permitted);
			//同时具有那些权限
			boolean permittedAll = subject.isPermittedAll("product:findAll","user:delete:003","user:update","product:add");
			System.out.println(permittedAll);
			//分别具有那些权限字符串
			boolean[] permitted2 = subject.isPermitted("product:findAll","user:delete:003","user:update","product:add");
			for (boolean b : permitted2) {
				System.out.println(b);
			}
			
			
			Realm realm;
			
			
			Authenticator authenticator;//认证
			Authorizer authorizer;//授权
			
			
		}
		
		
		
		
	}
	
}
