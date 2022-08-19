package com.citi.project.team1.services;

import com.citi.project.team1.entities.Stock;
import com.citi.project.team1.repos.StockRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockServiceImplementation implements StockService{

    private static final Logger logger = LogManager.getLogger(OrderServiceImplementation.class);

    @Autowired
    private StockRepository dao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<Stock> getAllStocks(){
        logger.info("getting the catalog");

        return dao.findAll();
    }



    @Override
    public Stock addNewStock(Stock stock){
        return dao.save(stock);
    }

    @Override
    public void deleteByTicker(String ticker) {
        Stock toBeDeleted = dao.findByTicker(ticker);
        deleteStock(toBeDeleted);

    }

    @Override
    public Stock findByTicker(String ticker) {

       return dao.findByTicker(ticker);

    }

    @Override
    public void deleteStock(Stock stock){
        dao.delete(stock);
    }

    @Override
    public Stock updateStock(Stock stock){
        return dao.save(stock);
    }

}
