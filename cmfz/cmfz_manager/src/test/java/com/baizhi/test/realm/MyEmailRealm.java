package com.baizhi.test.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class MyEmailRealm extends AuthenticatingRealm{

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		
		//获取用户身份信息:
		System.out.println("Email "+token.getPrincipal());
		
		
		//根据邮箱查询的sql
		if("chenyn@zparkhr.com.cn".equals(token.getPrincipal())){
			
			//参数一:数据库身份信息
			//参数二:数据库中密码(加密 salt hash)
			//参数三:数据库中salt
			//参数四:realm 名字  
			return new SimpleAuthenticationInfo("zhangsan","294871161d4de259bd3c86e3aaab27c7", 
												ByteSource.Util.bytes("O9XZ"), this.getName());
		}
		
		
		return null;
	}

}
