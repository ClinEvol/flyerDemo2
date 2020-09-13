package com.ujiuye.pojo;

public class CarOrder {
    private int cid;
    private String oid;
    private int state;

    private OrderInfo orderInfo;

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public CarOrder(int cid, String oid, int state) {
        this.cid = cid;
        this.oid = oid;
        this.state = state;
    }

    public CarOrder() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
