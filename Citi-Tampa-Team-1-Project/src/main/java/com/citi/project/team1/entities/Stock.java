package com.citi.project.team1.entities;


import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name = "stocks")


public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // add attributes for all the remaining properties
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "currency")
    private String currency;
    @Column(name = "market_time")
    private String market_time;
    @Column(name = "volume")
    private int volume;
    @Column(name = "last_price")
    private Double last_price;

    public Stock() {}

    public Stock(int id, String symbol, String currency, String market_time, int volume, Double last_price) {
        this.id = id;
        this.symbol = symbol;
        this.currency = currency;
        this.market_time = market_time;
        this.volume = volume;
        this.last_price = last_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMarket_time() {
        return market_time;
    }

    public void setMarket_time(String market_time) {
        this.market_time = market_time;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Double getLast_price() {
        return last_price;
    }

    public void setLast_price(Double last_price) {
        this.last_price = last_price;
    }
}

