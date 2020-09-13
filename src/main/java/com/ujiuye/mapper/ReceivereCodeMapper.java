package com.ujiuye.mapper;

import com.ujiuye.pojo.ReceivereCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReceivereCodeMapper {
    int save(ReceivereCode receivereCode);

    ReceivereCode getByOnum(String onum);
    int update(ReceivereCode receivereCode);


    List<ReceivereCode> listByStateAndEid(@Param("state") int state, @Param("eid") int eid);
}
