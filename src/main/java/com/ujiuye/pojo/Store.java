package com.ujiuye.pojo;

import java.io.Serializable;
import java.util.Date;

public class Store implements Serializable {
   private int sid;
   private int lid;
   private String sname;
   private String address;
   private int state;
   private Date createtime;
   private int aid;
   private String remark;
   private Area area;
   private Level level;

   public Area getArea() {
      return area;
   }

   public void setArea(Area area) {
      this.area = area;
   }

   public Level getLevel() {
      return level;
   }

   public void setLevel(Level level) {
      this.level = level;
   }

   public int getSid() {
      return sid;
   }

   public void setSid(int sid) {
      this.sid = sid;
   }

   public int getLid() {
      return lid;
   }

   public void setLid(int lid) {
      this.lid = lid;
   }

   public String getSname() {
      return sname;
   }

   public void setSname(String sname) {
      this.sname = sname;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
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

   public int getAid() {
      return aid;
   }

   public void setAid(int aid) {
      this.aid = aid;
   }

   public String getRemark() {
      return remark;
   }

   public void setRemark(String remark) {
      this.remark = remark;
   }

   @Override
   public String toString() {
      return "Store{" +
              "sid='" + sid + '\'' +
              ", lid='" + lid + '\'' +
              ", sname='" + sname + '\'' +
              ", address='" + address + '\'' +
              ", state='" + state + '\'' +
              ", createtime='" + createtime + '\'' +
              ", aid='" + aid + '\'' +
              ", remark='" + remark + '\'' +
              '}';
   }
}
