package com.ujiuye.mapper;

import com.ujiuye.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    List<Car> listByStateAndSid(@Param("state") int state,@Param("sid") int sid);
    int update(Car car);
    Car getById(int id);
    int save(Car car);
}
