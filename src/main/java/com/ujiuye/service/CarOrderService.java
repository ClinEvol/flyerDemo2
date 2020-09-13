package com.ujiuye.service;

import com.ujiuye.pojo.CarOrder;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface CarOrderService {
    List<CarOrder> list(HttpSession session);
}
