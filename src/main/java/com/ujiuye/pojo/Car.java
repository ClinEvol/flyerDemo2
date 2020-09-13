package com.ujiuye.pojo;

import java.util.Date;

public class Car {
    private int cid;
    private String carnum;
    private int state;
    private Date createtime;
    private int fromsid;
    private int tosid;
    private Store fromStore;
    private Store toStore;

    public Store getFromStore() {
        return fromStore;
    }

    public void setFromStore(Store fromStore) {
        this.fromStore = fromStore;
    }

    public Store getToStore() {
        return toStore;
    }

    public void setToStore(Store toStore) {
        this.toStore = toStore;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getFromsid() {
        return fromsid;
    }

    public void setFromsid(int fromsid) {
        this.fromsid = fromsid;
    }

    public int getTosid() {
        return tosid;
    }

    public void setTosid(int tosid) {
        this.tosid = tosid;
    }
}
