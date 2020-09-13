package com.ujiuye.controller;

import com.ujiuye.pojo.CarOrder;
import com.ujiuye.service.CarOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/carorder")
public class CarOrderController {
    @Autowired
    private CarOrderService carOrderService;

    @RequestMapping("/list")
    public String list(Model model, HttpSession session){
        List<CarOrder> list = carOrderService.list(session);
        model.addAttribute("list",list);
        return "store-in";
    }
}
