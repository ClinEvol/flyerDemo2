package com.ujiuye.service;

import com.ujiuye.mapper.OrderInfoMapper;
import com.ujiuye.mapper.OrderRouteMapper;
import com.ujiuye.mapper.ReceivereCodeMapper;
import com.ujiuye.mapper.SendRecodeMapper;
import com.ujiuye.pojo.*;
import com.ujiuye.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private ReceivereCodeMapper receivereCodeMapper;
    @Autowired
    private OrderRouteMapper orderRouteMapper;
    @Autowired
    private SendRecodeMapper sendRecodeMapper;

    @Override
    public int save(OrderInfo orderInfo, HttpSession session) {
        //获取当前登录者
        Employee employee=(Employee)session.getAttribute("USER_SESSION");
        orderInfo.setEid(employee.getEid());
        orderInfo.setState(0);//代表未揽件
        orderInfo.setOnum(UUIDUtils.getUUID());
        orderInfo.setCreatetime(new Date());
        return orderInfoMapper.save(orderInfo);
    }

    @Override
    public List<OrderInfo> listByStats(int stats) {
        return orderInfoMapper.listByStats(stats);
    }

    @Override
    public int updateReceivere(String onum, HttpSession session) {
        //获取当前登录者
        Employee employee=(Employee)session.getAttribute("USER_SESSION");
        //先查要修改的订单对象
        OrderInfo orderInfo = orderInfoMapper.getByOnum(onum);
        //把状态改为1
        orderInfo.setState(1);
        //更新到数据库中
        orderInfoMapper.update(orderInfo);
        //添加一个揽件记录
        ReceivereCode receivereCode=new ReceivereCode(0,0,new Date(),orderInfo.getOnum(),employee.getEid());
        receivereCodeMapper.save(receivereCode);
        //添加线路记录
        OrderRoute orderRoute=new OrderRoute(0,0,new Date(),orderInfo.getOnum(),employee.getStore().getSid());
        orderRouteMapper.save(orderRoute);
        return 1;
    }

    @Override
    public int updateSend(String onum, HttpSession session) {
        //获取当前登录者
        Employee employee=(Employee)session.getAttribute("USER_SESSION");
        //先查要修改的订单对象
        OrderInfo orderInfo = orderInfoMapper.getByOnum(onum);
        //把状态改为1
        orderInfo.setState(3);
        //更新到数据库中
        orderInfoMapper.update(orderInfo);

        //添加线路记录
        OrderRoute orderRoute=new OrderRoute(0,0,new Date(),orderInfo.getOnum(),employee.getStore().getSid());
        orderRouteMapper.save(orderRoute);

        //派件记录表添加
        SendRecode sendRecode=new SendRecode(0,employee.getEid(),0,new Date(),orderInfo.getOnum());
        sendRecodeMapper.save(sendRecode);

        return 1;
    }

    @Override
    public List<DataResult> count() {
        return orderInfoMapper.count();
    }
}
