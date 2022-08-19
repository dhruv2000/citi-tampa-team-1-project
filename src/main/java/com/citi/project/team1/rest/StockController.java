package com.citi.project.team1.rest;

import com.citi.project.team1.entities.Stock;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.citi.project.team1.services.StockService;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin
public class StockController {
    private static Logger logger = LogManager.getLogger(StockController.class);


    @Autowired
    private StockService service;

    @ApiOperation(value = "findAll", nickname = "findAll")
    @GetMapping
    public Iterable<Stock> findAll() {
        logger.info("managed to call a Get request for findAll");
        return service.getAllStocks();
    }

    @GetMapping("/{ticker}")
    public Stock getStockByTicker(@PathVariable("ticker") String ticker) {
        return service.findByTicker(ticker);
    }

    //    @RequestMapping (method = RequestMethod.POST)
    @PostMapping()
    public void addStock(@RequestBody Stock stock){
        service.addNewStock(stock);
    }

    @PutMapping()
    public void updateStock(@RequestBody Stock stock){
        service.updateStock(stock);
    }

    @DeleteMapping()
    public void deleteStock(@RequestBody Stock stock) {
        service.deleteStock(stock);
    }

    @DeleteMapping("/{ticker}")
    public void deleteStockByTicker(@PathVariable("ticker") String ticker) {
        service.deleteByTicker(ticker);
    }


}
