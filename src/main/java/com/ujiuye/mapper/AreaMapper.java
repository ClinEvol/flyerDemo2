package com.ujiuye.mapper;

import com.ujiuye.pojo.Area;

import java.util.List;

public interface AreaMapper {
    List<Area> list();
    int save(Area area);
    Area getById(int id);
}
