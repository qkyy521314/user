package com.baizhi.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义角色Filter 关系为  只要有一个角色满足即可
 * @author Administrator
 *
 */
public class CustomRolesAuthorizationFilter extends AuthorizationFilter {
//自定义Filter继承AuthorizationFilter抽象类,而该类有继承AccessControlFilter抽象类,我们自定义的方法从写AccessControlFilter
//类中的isAccessAllowed()方法
//当前用的所有角色mappedValue
//在本类中通过getSubject()

	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
			//
		Subject subject = getSubject(request, response);
		String roles[] = 	(String [])mappedValue;
		
		if(roles==null || roles.length==0){
			return true;
		}
		
		for (String role : roles) {
			if(subject.hasRole(role)){
				return true;
			}
		}
		
		return false;
	}

}
