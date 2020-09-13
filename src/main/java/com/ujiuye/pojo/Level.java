package com.ujiuye.pojo;

import java.util.Date;

public class Level {
    private int lid;
    private int grade;
    private int state;
    private Date createtime;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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
        return "Level{" +
                "lid=" + lid +
                ", grade=" + grade +
                ", state=" + state +
                ", createtime=" + createtime +
                '}';
    }
}
