package com.citi.project.team1.entities;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity @Table(name="orders")




public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    // add attributes for all the remaining properties
    @Column(name="order_type") private String order_type;
    @Column(name="price") private Double price;
    @Column(name="time_of_day") private String time_of_day;
    @Column(name="asset") private String asset;
    @Column(name="status_code") private int status_code;
    @Column(name="num_shares") private int num_shares;
    @Column(name="ticker") private String ticker;

    public Order(){}

    public Order(String order_type, Double price, String time_of_day, String asset, int status_code, int num_shares, String ticker) {
        this.order_type = order_type;
        this.price = price;
        this.time_of_day = time_of_day;
        this.asset = asset;
        this.status_code = status_code;
        this.num_shares = num_shares;
        this.ticker = ticker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTime_of_day() {
        return time_of_day;
    }

    public void setTime_of_day(String time_of_day) {
        this.time_of_day = time_of_day;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public int getNum_shares() {
        return num_shares;
    }

    public void setNum_shares(int num_shares) {
        this.num_shares = num_shares;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
}