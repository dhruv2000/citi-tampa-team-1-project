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
    @Column(name="time_of_day") private String timeOfDay;
    @Column(name="asset") private String asset;
    @Column(name="status_code") private int status_code;
    @Column(name="num_shares") private int numShares;
    @Column(name="ticker") private String ticker;

    public Order(){}

    public Order(int id, String order_type, Double price, String timeOfDay, String asset, int status_code, int numShares, String ticker) {
        this.id = id;
        this.order_type = order_type;
        this.price = price;
        this.timeOfDay = timeOfDay;
        this.asset = asset;
        this.status_code = status_code;
        this.numShares = numShares;
        this.ticker = ticker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderType() {
        return order_type;
    }

    public void setOrderType(String order_type) {
        this.order_type = order_type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
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

    public int getNumShares() {
        return numShares;
    }

    public void setNumShares(int numShares) {
        this.numShares = numShares;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
}