package com.baizhi.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by DELL on 2018/1/14.
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new ContextInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
