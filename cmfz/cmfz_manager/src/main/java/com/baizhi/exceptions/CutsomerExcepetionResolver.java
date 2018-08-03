package com.baizhi.exceptions;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义全局异常处理类
 * @author Administrator
 *
 */
public class CutsomerExcepetionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception e) {
		
		if(e instanceof UnauthorizedException){
			return new ModelAndView("redirect:/unauthoriz.jsp");
		}
		
		return null;
	}

}
