package com.ujiuye.service;

import com.ujiuye.mapper.*;
import com.ujiuye.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private ReceivereCodeMapper receivereCodeMapper;
    @Autowired
    private OutInStoreMapper outInStoreMapper;
    @Autowired
    private CarOrderMapper carOrderMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Override
    public List<Store> list() {
        return storeMapper.list();
    }

    @Override
    public int save(Store store) {
        store.setCreatetime(new Date());
        return storeMapper.save(store);
    }

    @Override
    public int updateOutStore(String oid, int cid, int sid, int eid) {
        //出库时，把揽件记录表（receiverecode）的状态改为1
        ReceivereCode receivereCode = receivereCodeMapper.getByOnum(oid);
        receivereCode.setState(1);
        receivereCodeMapper.update(receivereCode);

        //向出入库记录表（outinstore）添加一条出库的记录，状态(0入库，1出库)
        OutInStore outInStore=new OutInStore(0,1,new Date(),sid,oid,eid);
        outInStoreMapper.save(outInStore);

        //向车库记单表添加记录carorder，代表这个单装载这辆车
        CarOrder carOrder=new CarOrder(cid,oid,0);
        carOrderMapper.save(carOrder);
        return 1;
    }

    @Override
    public int updateInStore(String oid, int sid, int eid) {
        //把已经入库的订单从carorder表中删了
        carOrderMapper.remove(oid);
        //修改订单为待派件
        OrderInfo orderInfo = orderInfoMapper.getByOnum(oid);
        orderInfo.setState(2);
        orderInfoMapper.update(orderInfo);
        //向出入表中添加一个入库记录,状态(0入库，1出库)
        OutInStore outInStore=new OutInStore(0,0,new Date(),sid,oid,eid);
        outInStoreMapper.save(outInStore);
        return 1;
    }
}
