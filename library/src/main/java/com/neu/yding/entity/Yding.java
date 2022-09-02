package com.neu.yding.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")

public class Yding {
    private int yid;
    private Date ystarttime;
    private Date yendtime;
    private int u_id;
    private int b_id;
    private String status;

    public Yding() {
    }

    public Yding(int yid, Date ystarttime, Date yendtime, int u_id, int b_id, String status) {
        this.yid = yid;
        this.ystarttime = ystarttime;
        this.yendtime = yendtime;
        this.u_id = u_id;
        this.b_id = b_id;
        this.status = status;
    }

    public Yding(Date ystarttime, Date yendtime, int u_id, int b_id, String status) {
        this.ystarttime = ystarttime;
        this.yendtime = yendtime;
        this.u_id = u_id;
        this.b_id = b_id;
        this.status = status;
    }

    public int getYid() {
        return yid;
    }

    public void setYid(int yid) {
        this.yid = yid;
    }

    public Date getYstarttime() {
        return ystarttime;
    }

    public void setYstarttime(Date ystarttime) {
        this.ystarttime = ystarttime;
    }

    public Date getYendtime() {
        return yendtime;
    }

    public void setYendtime(Date yendtime) {
        this.yendtime = yendtime;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
