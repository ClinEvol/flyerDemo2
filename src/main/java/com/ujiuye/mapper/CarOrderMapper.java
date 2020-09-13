package com.ujiuye.mapper;

import com.ujiuye.pojo.CarOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarOrderMapper {
    int save(CarOrder carOrder);

    /**
     *
     * @param cidList 是车辆id集合
     * @param state 当前订单状态
     * @return
     */
    List<CarOrder> list(@Param("cidList") List<Integer> cidList, @Param("state") int state);
    int remove(String oid);
    int updateStateByCid(@Param("cid")int cid,@Param("state") int state);
}
