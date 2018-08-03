package com.baizhi.shiro.realm;

import com.baizhi.dao.ManagerDAO;
import com.baizhi.entity.Manager;
import com.baizhi.entity.Role;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

/**
 *自定义realm
 */
public class CustomerRealm extends AuthorizingRealm {

	@Resource
	private ManagerDAO managerDAO;

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		
		System.out.println("*****************"+principals.getPrimaryPrincipal());

		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		Manager manager = managerDAO.queryOneByNameRole(principals.getPrimaryPrincipal().toString());
		List<Role> list = manager.getRoles();
		for (Role role : list) {
			simpleAuthorizationInfo.addRole(role.getRole_name());
		}

//		simpleAuthorizationInfo.addStringPermission("product:delete");
//		simpleAuthorizationInfo.addStringPermission("product:update");
		//simpleAuthorizationInfo.addStringPermission("product:findAll");
		//用户    角色  权限 -----(资源)  user:add:    /user/add   安装系统
		return simpleAuthorizationInfo;

	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("用户名====: "+token.getPrincipal());

		Manager manager = managerDAO.queryOneByName(token.getPrincipal().toString());
		if(manager.getName().equals(token.getPrincipal())){
			return new SimpleAuthenticationInfo(manager.getName(), manager.getPassword(),
					ByteSource.Util.bytes(manager.getM_salt()),
					this.getName());

		}
		return null;
	}

}
