package com.ujiuye.controller;

import com.ujiuye.pojo.Employee;
import com.ujiuye.pojo.ReceivereCode;
import com.ujiuye.service.ReceivereCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("receiverecode")
@Controller
public class ReceivereCodeController {

    @Autowired
    private ReceivereCodeService receivereCodeService;

    @RequestMapping("/list")
    public String list(Model model, HttpSession session){
        Employee employee=(Employee) session.getAttribute("USER_SESSION");
        List<ReceivereCode> list = receivereCodeService.listByStateAndEid(0, employee.getEid());
        model.addAttribute("list",list);
        for (ReceivereCode receivereCode : list) {
            System.out.println(receivereCode.getOrderInfo());
        }
        return "store-out";
    }
}
