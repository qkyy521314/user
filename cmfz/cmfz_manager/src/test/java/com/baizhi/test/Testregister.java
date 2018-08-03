package com.baizhi.test;

import com.baizhi.advice.ManagerService;
import com.baizhi.entity.Manager;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by DELL on 2018/1/11.
 */
public class Testregister extends BaseTest{
    @Resource
    private ManagerService managerService;
    @Test
    public void add() {
        Manager manager =new Manager(null,"add","111111",1,true,null,null);
        managerService.register(manager);

    }
    @Test
    public void ab() {
        String hashAlgorithmName = "MD5";
        String credentials = "111111";
        int hashIterations = 1024;

        Object obj = new SimpleHash(hashAlgorithmName, credentials, "MB29", hashIterations);
        System.out.println(obj);
    }
    @Test
    public  void cd() {
        //使用md5加密算法 加密
        Md5Hash md5 = new Md5Hash("1111");
        System.out.println("加密=="+md5.toString());
        //加 盐
        md5 = new Md5Hash("1111", "wh");
        System.out.println("加盐加密=="+md5.toString());
        System.out.println(new Md5Hash(md5,"wh"));
        //迭代次数
        md5 = new Md5Hash("1111", "wh", 1);
        System.out.println("加盐加密散列=="+md5.toString());
        SimpleHash hash = new SimpleHash("md5", "1111", "wh", 1);
        System.out.println("加盐加密散列=="+hash.toString());
    }
}
