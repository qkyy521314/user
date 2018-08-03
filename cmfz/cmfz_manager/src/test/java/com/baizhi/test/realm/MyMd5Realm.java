package com.baizhi.test.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;

/**
 * 自定义realm 从数据库数据
 * @author Administrator
 *
 */
public class MyMd5Realm extends AuthenticatingRealm {

	
	//<bean class="org.apache.shiro.authc.credential.HashedCredentialsMatcher"
	//<property name="credentialsMatcher"  ref="">
	/*@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		// TODO Auto-generated method stub
		super.setCredentialsMatcher(credentialsMatcher);
	}*/
	
	//认证的方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		//token
		System.out.println("用户身份信息:" +token.getPrincipal());
		
		//根据用户名查询用户信息   User
		if("zhangsan".equals(token.getPrincipal())){
			//参数一:身份信息
			//参数二:数据库中密码
			//参数三:realm名称  全局唯一
			return new SimpleAuthenticationInfo("zhangsan", "e10adc3949ba59abbe56e057f20f883e", this.getName());
		}
		
		return null;
	}

}
