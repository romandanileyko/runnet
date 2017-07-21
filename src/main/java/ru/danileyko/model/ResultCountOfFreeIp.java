package ru.danileyko.model;

import javax.management.relation.Role;

/**
 * Created by danil on 20.07.2017.
 */
public class ResultCountOfFreeIp {
    private String name;
    private String ipange;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpange() {
        return ipange;
    }

    public void setIpange(String ipange) {
        this.ipange = ipange;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
