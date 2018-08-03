package com.baizhi.test.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;

/**
 * Created by DELL on 2018/1/22.
 */

public class MyRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //token
        System.out.println("用户身份信息:" +token.getPrincipal());

        //根据用户名查询用户信息   User
        if("zhangsan".equals(token.getPrincipal())){
            //参数一:身份信息
            //参数二:数据库中密码
            //参数三:realm名称  全局唯一
            return new SimpleAuthenticationInfo("zhangsan", "123456",this.getName());
        }
        return null;
    }
}
