package com.ujiuye.controller;

import com.alibaba.fastjson.JSON;
import com.ujiuye.pojo.Area;
import com.ujiuye.pojo.Employee;
import com.ujiuye.pojo.Store;
import com.ujiuye.service.AreaService;
import com.ujiuye.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private AreaService areaService;

    @RequestMapping("/listJSON")
    @ResponseBody
    public String listJSON(){
        List<Store> list = storeService.list();
        //把集合转成JSON格式的字符返回给前台
        return JSON.toJSONString(list);
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<Store> list = storeService.list();
        model.addAttribute("list",list);
        return "store-list";
    }

    @RequestMapping("/tosave")
    public String tosave(Model model){
        //查询添加页面中所需要的区域列表
        List<Area> list = areaService.list();
        model.addAttribute("list",list);
        return "store-add";
    }
    @RequestMapping("/save")
    @ResponseBody
    public String save(Store store){
        try {
            storeService.save(store);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @RequestMapping("outStore")
    @ResponseBody
    public String outStore(String oid, int cid, HttpSession session){
        try {
            Employee employee=(Employee)session.getAttribute("USER_SESSION");
            int eid = employee.getEid();
            int sid = employee.getStore().getSid();//获取当前门店的id
            storeService.updateOutStore(oid,cid,sid,eid);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }


    @RequestMapping("inStore")
    @ResponseBody
    public String inStore(String oid, HttpSession session){
        try {
            Employee employee=(Employee)session.getAttribute("USER_SESSION");
            int eid = employee.getEid();
            int sid = employee.getStore().getSid();//获取当前门店的id
            storeService.updateInStore(oid,sid,eid);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }


}
