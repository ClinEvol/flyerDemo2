package com.ujiuye.pojo;

import java.util.Date;

public class OrderRoute {
    private int orid;
    private int state;
    private Date updatetime;
    private String oid;	//订单号
    private int sid;

    public OrderRoute(int orid, int state, Date updatetime, String oid, int sid) {
        this.orid = orid;
        this.state = state;
        this.updatetime = updatetime;
        this.oid = oid;
        this.sid = sid;
    }

    public OrderRoute() {
    }

    public int getOrid() {
        return orid;
    }

    public void setOrid(int orid) {
        this.orid = orid;
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

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
