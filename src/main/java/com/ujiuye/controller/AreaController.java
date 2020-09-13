package com.ujiuye.controller;

import com.ujiuye.pojo.Area;
import com.ujiuye.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/area")
@Controller
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Area> list = areaService.list();
        model.addAttribute("list",list);
        return "area-list";
    }

    @RequestMapping("/tosave")
    public String tosave(){
        return "area-add";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save(Area area){
        try {
            areaService.save(area);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }

    }
}
