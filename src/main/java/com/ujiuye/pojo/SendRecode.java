package com.ujiuye.pojo;

import java.util.Date;

public class SendRecode {
    private int srid;
    private int eid;
    private int state;
    private Date upatetime;
    private String  oid;

    public SendRecode(int srid, int eid, int state, Date upatetime, String oid) {
        this.srid = srid;
        this.eid = eid;
        this.state = state;
        this.upatetime = upatetime;
        this.oid = oid;
    }

    public SendRecode() {
    }

    public int getSrid() {
        return srid;
    }

    public void setSrid(int srid) {
        this.srid = srid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getUpatetime() {
        return upatetime;
    }

    public void setUpatetime(Date upatetime) {
        this.upatetime = upatetime;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        return "SendRecode{" +
                "srid=" + srid +
                ", eid=" + eid +
                ", state=" + state +
                ", upatetime=" + upatetime +
                ", oid='" + oid + '\'' +
                '}';
    }
}
