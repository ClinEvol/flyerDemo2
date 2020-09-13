package com.ujiuye.service;

import com.ujiuye.pojo.Store;

import java.util.List;

public interface StoreService {
    List<Store> list();
    int save(Store store);
    //出库
    int updateOutStore(String oid,int cid,int sid,int eid);
    int updateInStore(String oid,int sid,int eid);
}
