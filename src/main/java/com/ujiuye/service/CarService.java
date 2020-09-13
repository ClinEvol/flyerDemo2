package com.ujiuye.service;

import com.ujiuye.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarService {
    List<Car> listByStateAndSid(int state, int sid);
    int updateByCidTravel(int cid);
    int updateByCidEmpty(int cid);
    int save(Car car);
}
