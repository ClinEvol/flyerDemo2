package com.ujiuye.service;

import com.ujiuye.pojo.ReceivereCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReceivereCodeService {
    List<ReceivereCode> listByStateAndEid(int state,int eid);
}
