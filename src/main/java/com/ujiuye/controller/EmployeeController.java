package com.ujiuye.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.pojo.Employee;
import com.ujiuye.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/list")
    public String list(Model model, Date beginTime, Date endTime, String username,
                       @RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum){
        //设置分页的参数  第一个参数：第几页   第二参数：每页几条
        PageHelper.startPage(pageNum,5);
        //先设置分页的参数再进行查询
        List<Employee> list = employeeService.list(username,beginTime,endTime);
        //创建一个分页对象  分页对象是包含了所有的分页信息    把list集合作为参数
        PageInfo<Employee> pageInfo=new PageInfo<>(list);
        //把分页对象存入域中
        model.addAttribute("pageInfo",pageInfo);
        return "admin-list";
    }






    //执行登录操作
    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password, String code, String online, HttpSession session, HttpServletResponse response){
        //验证码判断
        String sysCode = (String) session.getAttribute("CODE_SESSION");
        if(!sysCode.equalsIgnoreCase(code)){
            return "error";
        }
        Employee employee = employeeService.getByUserName(username);
        if(employee!=null){//通过用户名查到对象
            //判断密码是否正确
            if(employee.getPassword().equals(password)){//密码正确
                //把用户信息存到域中
                session.setAttribute("USER_SESSION",employee);
                if("on".equals(online)){//用户勾了记住登录
                    addCookie(response,employee.getUsername());
                }
                return "true";
            }
        }
        return "false";
    }
    //添加Cookie
    private void addCookie(HttpServletResponse response,String username){
        Cookie cookie=new Cookie("username",username);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*7);
        response.addCookie(cookie);
    }

    //跳转到登录页面
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }


    //切换帐号
    @RequestMapping("/change")
    public String change(HttpSession session){
        //把刚才登录的信息从session中的移除
        session.removeAttribute("USER_SESSION");
        //跳转到登录页面
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session,HttpServletResponse response){
        //把刚才登录的信息从session中的移除
        session.removeAttribute("USER_SESSION");
        //清除Cookie
        Cookie cookie=new Cookie("username",null);
        cookie.setPath("/");
        cookie.setMaxAge(0);//存活时间为0秒，相当于删除
        response.addCookie(cookie);
        //跳转到登录页面
        return "login";
    }

    @RequestMapping("/tosave")
    public String tosave(){
        return "admin-add";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save(Employee employee){
        try {
            employeeService.save(employee);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

}
