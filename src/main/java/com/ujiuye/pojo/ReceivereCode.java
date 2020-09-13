package com.ujiuye.pojo;

import java.util.Date;

public class ReceivereCode {
    private int rrid;
    private int state;
    private Date updatetime;
    private String oid;
    private int eid;
    private OrderInfo orderInfo;

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public ReceivereCode(int rrid, int state, Date updatetime, String oid, int eid) {
        this.rrid = rrid;
        this.state = state;
        this.updatetime = updatetime;
        this.oid = oid;
        this.eid = eid;
    }

    public ReceivereCode() {
    }

    public int getRrid() {
        return rrid;
    }

    public void setRrid(int rrid) {
        this.rrid = rrid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }
}
