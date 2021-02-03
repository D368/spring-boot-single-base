package com.tse.cost.config;

import com.tse.cost.interceptor.CustomInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author liangw
 * @date 2020/8/28 15:13
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private CustomInterceptor customInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customInterceptor).addPathPatterns("/**")
                //登录相关
                .excludePathPatterns("/auth/**")
                //系统相关
                .excludePathPatterns("/actuator/**","/error","/favicon.ico")
                //接口文档相关
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/doc.html/**")
                //文件上传相关
                .excludePathPatterns("/attachment/**")
                //excel导出
                .excludePathPatterns("/**/export")
                //其他
                .excludePathPatterns("/ticket/get/**","/records/add");
    }
}
