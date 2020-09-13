package com.ujiuye.pojo;

import java.util.Date;

public class OrderInfo {
    private String onum;
    private int eid;
    private double price;
    private String fromname;
    private String fromaddress;
    private String fromtel;
    private String toname;
    private String toaddress;
    private String totel;
    private String fromCardNum;
    private int state;
    private Date createtime;

    public String getOnum() {
        return onum;
    }

    public void setOnum(String onum) {
        this.onum = onum;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFromname() {
        return fromname;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname;
    }

    public String getFromaddress() {
        return fromaddress;
    }

    public void setFromaddress(String fromaddress) {
        this.fromaddress = fromaddress;
    }

    public String getFromtel() {
        return fromtel;
    }

    public void setFromtel(String fromtel) {
        this.fromtel = fromtel;
    }

    public String getToname() {
        return toname;
    }

    public void setToname(String toname) {
        this.toname = toname;
    }

    public String getToaddress() {
        return toaddress;
    }

    public void setToaddress(String toaddress) {
        this.toaddress = toaddress;
    }

    public String getTotel() {
        return totel;
    }

    public void setTotel(String totel) {
        this.totel = totel;
    }

    public String getFromCardNum() {
        return fromCardNum;
    }

    public void setFromCardNum(String fromCardNum) {
        this.fromCardNum = fromCardNum;
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

    @Override
    public String toString() {
        return "OrderInfo{" +
                "onum='" + onum + '\'' +
                ", eid=" + eid +
                ", price=" + price +
                ", fromname='" + fromname + '\'' +
                ", fromaddress='" + fromaddress + '\'' +
                ", fromtel='" + fromtel + '\'' +
                ", toname='" + toname + '\'' +
                ", toaddress='" + toaddress + '\'' +
                ", totel='" + totel + '\'' +
                ", fromCardNum='" + fromCardNum + '\'' +
                ", state=" + state +
                ", createtime=" + createtime +
                '}';
    }
}
