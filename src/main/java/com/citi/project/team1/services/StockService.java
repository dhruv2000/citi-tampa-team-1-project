package com.citi.project.team1.services;

import com.citi.project.team1.entities.Order;
import com.citi.project.team1.entities.Stock;

public interface StockService {


    Iterable<Stock> getAllStocks();

    Stock addNewStock(Stock stock);

   void deleteByTicker(String ticker);

    Stock findByTicker(String ticker);

    void deleteStock(Stock stock);

    Stock updateStock(Stock stock);

}
