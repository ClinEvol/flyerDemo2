package com.ujiuye.service;

import com.ujiuye.mapper.AreaMapper;
import com.ujiuye.pojo.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> list() {
        return areaMapper.list();
    }

    @Override
    public int save(Area area) {
        area.setState(0);
        area.setCreatetime(new Date());
        return areaMapper.save(area);
    }
}
