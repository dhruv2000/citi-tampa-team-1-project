package com.citi.project.team1.rest;

import com.citi.project.team1.entities.Order;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.OrderService;

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

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable("id") int id) {
        return service.getStockByID(id);
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

    @DeleteMapping("/{id}")
    public void deleteStockById(@PathVariable("id") int id) {
        service.deleteStockbyID(id);
    }


}
