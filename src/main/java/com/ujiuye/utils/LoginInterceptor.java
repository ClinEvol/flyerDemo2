package com.ujiuye.utils;

import com.ujiuye.pojo.Employee;
import com.ujiuye.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private EmployeeService employeeService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        //开放静态资源
        if(uri.contains("lib") || uri.contains("static") || uri.contains("temp")){
            return true;
        }
        //判断是否为跳转到登录页还是登录操作
        if(uri.contains("login")){
           return true;
        }
        //如果都不是，那判断是否已经登录
        Employee employee=(Employee)request.getSession().getAttribute("USER_SESSION");
        if(employee!=null){//已经登录
            return true;
        }else{//没有登录，去cookie看一有没有记录
            Cookie[] cookies = request.getCookies();
            String username="";
            boolean isLogin=false;//cookie是否存在
            if(cookies==null || cookies.length==0){
                return false;
            }
            for (Cookie cookie : cookies) {
                if("username".equals(cookie.getName())){//存在username的cookie
                    username=cookie.getValue();
                    isLogin=true;//找到cookie修为true
                    break;
                }
            }
            if(isLogin){//cookie存在
                //重新查出该用户信息并放到session中，放行
                Employee employee1 = employeeService.getByUserName(username);
                request.getSession().setAttribute("USER_SESSION",employee1);
                return true;
            }
        }
        //没有登录跳转到登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
