package com.ujiuye.controller;

import com.ujiuye.pojo.Car;
import com.ujiuye.pojo.Employee;
import com.ujiuye.pojo.Store;
import com.ujiuye.service.CarService;
import com.ujiuye.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/car")
@Controller
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private StoreService storeService;

    @RequestMapping("/list")
    public String list(Model model, HttpSession session){
        Employee employee=(Employee) session.getAttribute("USER_SESSION");
        int sid = employee.getStore().getSid();
        List<Car> list = carService.listByStateAndSid(0, sid);
        model.addAttribute("list",list);
        return "car-choose";
    }

    @RequestMapping("/listEmpty")
    public String listEmpty(Model model, HttpSession session){
        Employee employee=(Employee) session.getAttribute("USER_SESSION");
        int sid = employee.getStore().getSid();
        List<Car> list = carService.listByStateAndSid(0, sid);
        model.addAttribute("list",list);
        return "car-empty";
    }

    @RequestMapping("/travelList")
    public String travelList(Model model, HttpSession session){
        Employee employee=(Employee) session.getAttribute("USER_SESSION");
        int sid = employee.getStore().getSid();
        List<Car> list = carService.listByStateAndSid(1, sid);
        model.addAttribute("list",list);
        return "car-travel";
    }


    @RequestMapping("/updateTravel")
    @ResponseBody
    public String updateTravel(int cid){
        try {
            carService.updateByCidTravel(cid);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @RequestMapping("/updateEmpty")
    @ResponseBody
    public String updateEmpty(int cid){
        try {
            carService.updateByCidEmpty(cid);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @RequestMapping("/tosave")
    public String tosave(Model model){
        //查询所有门店
        List<Store> list = storeService.list();
        model.addAttribute("list",list);
        return "car-add";
    }
    @RequestMapping("/save")
    @ResponseBody
    public String save(Car car){
        try {
            carService.save(car);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

}
