package com.neu.user.compont;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String username=(String)request.getSession().getAttribute("username");
        if(username==null){
            response.sendRedirect("http://localhost:8080");
            return false;
        }else{
            System.out.println("进入拦截器");
            return true;
        }
    }
}
