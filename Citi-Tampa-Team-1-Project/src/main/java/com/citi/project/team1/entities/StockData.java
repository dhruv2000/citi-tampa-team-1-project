package com.citi.project.team1.entities;

public class StockData {

    String ticker;
    StockInfo[] price_data;

    public StockData(){}

    public StockData(String ticker, StockInfo[] price_data) {
        this.ticker = ticker;
        this.price_data = price_data;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public StockInfo[] getPrice_data() {
        return price_data;
    }

    public void setPrice_data(StockInfo[] price_data) {
        this.price_data = price_data;
    }
}
