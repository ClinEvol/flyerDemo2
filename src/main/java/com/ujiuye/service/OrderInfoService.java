package com.ujiuye.service;

import com.ujiuye.pojo.DataResult;
import com.ujiuye.pojo.OrderInfo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderInfoService {
    int save(OrderInfo orderInfo, HttpSession session);
    List<OrderInfo> listByStats(int stats);

    int updateReceivere(String onum,HttpSession session);

    int updateSend(String onum,HttpSession session);
    List<DataResult> count();
}
