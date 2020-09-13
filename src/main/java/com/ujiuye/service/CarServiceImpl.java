package com.ujiuye.service;

import com.ujiuye.mapper.CarMapper;
import com.ujiuye.mapper.CarOrderMapper;
import com.ujiuye.mapper.OrderInfoMapper;
import com.ujiuye.pojo.Car;
import com.ujiuye.pojo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private CarOrderMapper carOrderMapper;
    @Override
    public List<Car> listByStateAndSid(int state, int sid) {
        return carMapper.listByStateAndSid(state,sid);
    }

    @Override
    public int updateByCidTravel(int cid) {
        // 1、修改车辆的状态为空闲（car表）
        Car car = carMapper.getById(cid);
        car.setState(0);
        carMapper.update(car);
        //2、修改这辆车的订单的状态，改为到达（carorder表(0正在运输，1已到达) ）
        carOrderMapper.updateStateByCid(cid,1);
        OrderInfo orderInfo=new OrderInfo();
        return 1;
    }

    @Override
    public int updateByCidEmpty(int cid) {
        // 1、修改车辆的状态为出发（car表）
        Car car = carMapper.getById(cid);
        car.setState(1);
        carMapper.update(car);
        //2、修改这辆车的订单的状态，改为到达（carorder表(0正在运输，1已到达) ）
        carOrderMapper.updateStateByCid(cid,0);
        return 1;
    }

    @Override
    public int save(Car car) {
        car.setState(0);
        car.setCreatetime(new Date());
        return carMapper.save(car);
    }
}
