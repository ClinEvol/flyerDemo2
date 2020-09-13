package com.ujiuye.service;

import com.ujiuye.mapper.ReceivereCodeMapper;
import com.ujiuye.pojo.ReceivereCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReceivereCodeServiceImpl implements ReceivereCodeService {
    @Autowired
    private ReceivereCodeMapper receivereCodeMapper;
    @Override
    public List<ReceivereCode> listByStateAndEid(int state, int eid) {
        return receivereCodeMapper.listByStateAndEid(state,eid);
    }
}
