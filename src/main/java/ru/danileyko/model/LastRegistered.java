package ru.danileyko.model;

import java.util.Date;

/**
 * Created by danil on 24.07.2017.
 */
public class LastRegistered {
    private String puser;
    private String hostelName;
    private String mac;
    private Date date;

    public String getPuser() {
        return puser;
    }

    public void setPuser(String puser) {
        this.puser = puser;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    private String ip;
}
