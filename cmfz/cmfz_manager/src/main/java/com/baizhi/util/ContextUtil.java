package com.baizhi.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DELL on 2018/1/14.
 */
public class ContextUtil {
    //请求和线程绑定
    private static ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<HttpServletRequest>();

    /**
     * 设置request
     */
    public static void setRequest(HttpServletRequest req){
        requestThreadLocal.set(req);
    }

    /**
     * 获得request
     */
    public static HttpServletRequest getRequest(){
        return requestThreadLocal.get();
    }
    /**
     *获得session
     */
//    public static HttpSession getSession(){
//        return requestThreadLocal.get().getSession();
//    }
}
