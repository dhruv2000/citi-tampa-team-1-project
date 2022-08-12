package com.citi.project.team1.entities;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity @Table(name="order")




public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    // add attributes for all the remaining properties
    @Column(name="type") private String type;
    @Column(name="price") private Double price;
    @Column(name="time") private String time;
    @Column(name="asset") private String asset;
    @Column(name="status_code") private int status_code;
    @Column(name="numshares") private int numshares;

    public Order() {}

    public Order(String type, Double price, String time, String asset, int status_code, int numshares) {
        this.type = type;
        this.price = price;
        this.time = time;
        this.asset = asset;
        this.status_code = status_code;
        this.numshares = numshares;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public int getNumshares() {
        return numshares;
    }

    public void setNumshares(int numshares) {
        this.numshares = numshares;
    }




}