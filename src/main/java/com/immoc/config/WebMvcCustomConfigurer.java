package com.immoc.config;

import com.immoc.controller.interceptor.OneInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcCustomConfigurer implements WebMvcConfigurer {

    /**
     * 拦截器按照顺序执行
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/**").excludePathPatterns("/one/**");
    }
}
