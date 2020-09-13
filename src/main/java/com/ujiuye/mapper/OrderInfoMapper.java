package com.ujiuye.mapper;

import com.ujiuye.pojo.DataResult;
import com.ujiuye.pojo.OrderInfo;

import java.util.List;

public interface OrderInfoMapper {
    int save(OrderInfo orderInfo);
    List<OrderInfo> listByStats(int stats);
    OrderInfo getByOnum(String onum);
    int update(OrderInfo orderInfo);

    List<DataResult> count();
}
