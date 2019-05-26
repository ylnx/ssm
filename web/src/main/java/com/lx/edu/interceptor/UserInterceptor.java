package com.lx.edu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-19 14:18
 */
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle.........");
        //拦截 如果没有登录信息则拦截并跳转login.jsp
        HttpSession session = request.getSession();
        //如果用户已登录也放行
        System.out.println("已经登录"+session.getAttribute("user")!=null);
        if(session.getAttribute("user")!=null){
            return true;
        }
        request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
        return false;
    }

}
