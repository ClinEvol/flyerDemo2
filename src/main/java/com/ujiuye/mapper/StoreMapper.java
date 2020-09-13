package com.ujiuye.mapper;

import com.ujiuye.pojo.Store;

import java.util.List;

public interface StoreMapper {
    /**
     * 通过主键查询门店
     * @param sid 主键id
     * @return 门店对象
     */
    Store getBySid(int sid);
    List<Store> list();
    int save(Store store);
}
