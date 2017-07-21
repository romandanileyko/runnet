package ru.danileyko.model;

/**
 * Created by danil on 19.07.2017.
 */
public class IpRange {
    private int id;
    private int num_hostel_id;
    private  String ip_range;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_hostel_id() {
        return num_hostel_id;
    }

    public void setNum_hostel_id(int num_hostel_id) {
        this.num_hostel_id = num_hostel_id;
    }

    public String getIp_range() {
        return ip_range;
    }

    public void setIp_range(String ip_range) {
        this.ip_range = ip_range;
    }
}
