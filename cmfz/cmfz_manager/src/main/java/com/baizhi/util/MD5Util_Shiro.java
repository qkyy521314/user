package com.baizhi.util;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.Random;

/**
 *
 * @date 2017年5月2日
 */
public class MD5Util_Shiro {

	public static void main(String[] args) {
		String hashAlgorithmName = "MD5";
		String credentials = "123456";
		int hashIterations = 1024;
		Object obj = new SimpleHash(hashAlgorithmName, credentials, getSalt(4), hashIterations);
		System.out.println(obj.toString());
	}

	/**
	 * JDK Md5加密 
	 */
	public static String shiroMD5(String target,String salt){
		String hashAlgorithmName = "MD5";
		String credentials = target;
		int hashIterations = 1024;
		Object obj = new SimpleHash(hashAlgorithmName,credentials, salt, hashIterations);
		System.out.println(obj.toString());
		return obj.toString();
	}
	
	/**
	 * 给用户密码加盐，增加安全性
	 */
	public static String getSalt(int count) {
		// 生成随机字符
		char[] str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

		// 随机数
		Random random = new Random();
		/**
		 * StringBuilder 线程不安全 效率高 常用 StringBuffer 线程安全 效率低
		 */
		String salt = "";
		for (int i = 0; i < count; i++) {
			salt += str[random.nextInt(str.length)];
		}

		return salt;
	}

}
