package com.noob.sportsdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.sql.Time;
import java.util.Date;

public class Event {
    @TableId(type = IdType.AUTO)
    private Integer eid;
    private String  ename;
    private Date edate;
    private Time etime;
    private String eplace;
    private String edis;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public Time getEtime() {
        return etime;
    }

    public void setEtime(Time etime) {
        this.etime = etime;
    }

    public String getEplace() {
        return eplace;
    }

    public void setEplace(String eplace) {
        this.eplace = eplace;
    }

    public String getEdis() {
        return edis;
    }

    public void setEdis(String edis) {
        this.edis = edis;
    }
}
