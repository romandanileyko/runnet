package ru.danileyko.model;

import java.util.Date;

/**
 * Created by danil on 19.07.2017.
 */
public class IpDetail {
    private int id;
    private String ip;
    private String mask;
    private int ip_range_id;
    private byte status;
    private String modifiedBy;
    private Date dateModified;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public int getIp_range_id() {
        return ip_range_id;
    }

    public void setIp_range_id(int ip_range_id) {
        this.ip_range_id = ip_range_id;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}
