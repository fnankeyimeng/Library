package com.neu.user.config;

import com.neu.user.compont.LoginIntercepter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/user/login","upload/upload");
    }
}
