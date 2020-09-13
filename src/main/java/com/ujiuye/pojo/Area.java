package com.ujiuye.pojo;

import java.util.Date;

public class Area {
    private Integer aid;
    private String province;
    private String city;
    private Integer state;
    private Date createtime;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
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
        return "Area{" +
                "aid=" + aid +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", state=" + state +
                ", createtime=" + createtime +
                '}';
    }
}
