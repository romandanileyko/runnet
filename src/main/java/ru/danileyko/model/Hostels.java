package ru.danileyko.model;

/**
 * Created by danil on 19.07.2017.
 */
public class Hostels {
    private int id;
    private String name;
    private int orderId;
    private int numHostelId;
    private int kHostelId;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getNumHostelId() {
        return numHostelId;
    }

    public void setNumHostelId(int numHostelId) {
        this.numHostelId = numHostelId;
    }

    public int getkHostelId() {
        return kHostelId;
    }

    public void setkHostelId(int kHostelId) {
        this.kHostelId = kHostelId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
