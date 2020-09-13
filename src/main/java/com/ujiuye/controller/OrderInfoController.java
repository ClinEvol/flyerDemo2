package com.ujiuye.controller;

import com.alibaba.fastjson.JSON;
import com.ujiuye.pojo.DataResult;
import com.ujiuye.pojo.OrderInfo;
import com.ujiuye.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/orderinfo")
@Controller
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(OrderInfo orderInfo, HttpSession session){
        try {
            orderInfoService.save(orderInfo,session);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @RequestMapping("/tosave")
    public String tosave(){
        return "order-add";
    }

    @RequestMapping("/list")
    public String listReceivere(Model model){
        List<OrderInfo> list = orderInfoService.listByStats(0);
        model.addAttribute("list",list);
        return "order-list";
    }

    @RequestMapping("/sendlist")
    public String sendlist(Model model){
        List<OrderInfo> list = orderInfoService.listByStats(2);
        model.addAttribute("list",list);
        return "order-send";
    }


    @RequestMapping("/updateReceivere")
    @ResponseBody
    public String updateReceivere(String onum, HttpSession session){
        try {
            orderInfoService.updateReceivere(onum,session);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @RequestMapping("/updateSend")
    @ResponseBody
    public String updateSend(String onum, HttpSession session){
        try {
            orderInfoService.updateSend(onum,session);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @RequestMapping("/count")
    @ResponseBody
    public String count(){
        List<DataResult> count = orderInfoService.count();
        return JSON.toJSONString(count);
    }

    @RequestMapping("/tocount")
    public String tocount(){
        return "charts-4";
    }

}
