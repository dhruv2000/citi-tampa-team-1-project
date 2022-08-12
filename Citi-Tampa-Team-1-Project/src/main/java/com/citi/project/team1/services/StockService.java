package com.citi.project.team1.services;

import com.citi.project.team1.entities.Order;
import com.citi.project.team1.entities.Stock;

public interface StockService {


    Iterable<Stock> getAllStocks();



    Stock addNewStock(Stock stock);

   void deleteBySym(String sym);

    Stock findBySymbol(String sym);

    void deleteStock(Stock stock);

    Stock updateStock(Stock stock);

}
