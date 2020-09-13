package com.ujiuye.service;

import com.ujiuye.mapper.CarMapper;
import com.ujiuye.mapper.CarOrderMapper;
import com.ujiuye.pojo.Car;
import com.ujiuye.pojo.CarOrder;
import com.ujiuye.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarOrderServiceImpl implements CarOrderService {
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private CarOrderMapper carOrderMapper;

    @Override
    public List<CarOrder> list(HttpSession session) {
        //查出本店有哪些空间车辆（car）
        Employee employee=(Employee)session.getAttribute("USER_SESSION");
        List<Car> carList = carMapper.listByStateAndSid(0, employee.getStore().getSid());
        if(carList==null || carList.size()==0){
            return null;
        }
        //根据这些车辆查询与本店相关的到达的车辆的订单（carorder）,关联订单表
        List<Integer> cidList=new ArrayList<>();
        for (Car car : carList) {
            cidList.add(car.getCid());
        }
        //车辆到达后状态改为1
        return carOrderMapper.list(cidList,1);
    }
}
