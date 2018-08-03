package com.baizhi.filter;


import com.baizhi.util.ContextUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by DELL on 2018/1/14.
 */
//@Component
//@ServletComponentScan
//@WebFilter(urlPatterns = "/com.baizhi.controller.ManagerController",filterName = "ContextFilter")
public class ContextFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将request 通过util类放入threadlocal
        System.out.println("filter 加入request");
        ContextUtil.setRequest((HttpServletRequest) servletRequest);
    }

    @Override
    public void destroy() {

    }
}
