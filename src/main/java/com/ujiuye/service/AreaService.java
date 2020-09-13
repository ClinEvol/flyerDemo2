package com.ujiuye.service;

import com.ujiuye.pojo.Area;

import java.util.List;

public interface AreaService {
    List<Area> list();
    int save(Area area);
}
