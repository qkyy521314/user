package com.baizhi.advice;

import com.baizhi.annotation.Detail;
import com.baizhi.entity.Log;
import com.baizhi.entity.Manager;
import com.baizhi.util.ContextUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by DELL on 2018/1/14.
 * 日志切面  什么人 在什么时间 干了什么事
 */
@Component
@Aspect
public class LogAdvice {
    @Resource
    private LogService logService;
    //环绕
    @Around("execution(* com.baizhi.service.*Impl.*(..))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest httpRequest  = ContextUtil.getRequest();
        System.out.println(httpRequest);
        //什么人  获取session
        Manager manager = (Manager) httpRequest.getSession().getAttribute("login");

        StringBuilder sb = new StringBuilder();
        System.out.println(manager);
        sb.append(manager.getName());

        //什么时间
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(format);
        sb.append("--on--"+format);

        //干什么

        //获得方法的签名
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature ms = (MethodSignature)signature;
        Method method = ms.getMethod();
        System.out.println(method.getName());
        //汉化
        Detail detail = method.getAnnotation(Detail.class);
        //Type type = method.getAnnotation(Type.class);
       // i++;
        System.out.println(detail.value());
        sb.append("--do--"+detail.value());
        //if(type == null || detail == null){
        //    return null;
        //

        Log log = new Log(UUID.randomUUID().toString(),manager.getName(),new Date(),sb.toString(),detail.value());
        logService.addLog(log);
        Object result = proceedingJoinPoint.proceed();
        return result;
    }
}
