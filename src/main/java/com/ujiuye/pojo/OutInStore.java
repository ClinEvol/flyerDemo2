package com.ujiuye.pojo;

import java.util.Date;

public class OutInStore {
    private int oiid;
    private int state;
    private Date createtime;
    private int sid	;
    private String oid;
    private int eid;

    public OutInStore(int oiid, int state, Date createtime, int sid, String oid, int eid) {
        this.oiid = oiid;
        this.state = state;
        this.createtime = createtime;
        this.sid = sid;
        this.oid = oid;
        this.eid = eid;
    }

    public OutInStore() {
    }

    public int getOiid() {
        return oiid;
    }

    public void setOiid(int oiid) {
        this.oiid = oiid;
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

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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
