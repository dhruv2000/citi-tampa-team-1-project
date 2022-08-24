package com.citi.project.team1.rest;

import com.citi.project.team1.entities.Order;
import com.citi.project.team1.entities.StockData;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.citi.project.team1.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {
    private static Logger logger = LogManager.getLogger(OrderController.class);


    @Autowired
    private OrderService service;

    @ApiOperation(value = "findAll", nickname = "findAll")
    @GetMapping
    public Iterable<Order> findAll() {
        logger.info("managed to call a Get request for findAll");
        return service.getAllOrders();
    }

    @GetMapping("/findByTicker/{ticker}")
    public List<Order> findByTicker(@PathVariable("ticker") String ticker) {
        logger.info("managed to call a Get request for findByTicker");
        return service.findByTicker(ticker);
    }
    

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") int id) {
        return service.getOrderByID(id);
    }

    @GetMapping("/updateOrderStatuses")
    public StockData updateOrderStatuses() {
        return service.updateOrderStatuses();
    }

    @PostMapping()
    public void addOrder(@RequestBody Order order){
        service.addNewOrder(order);
    }

    @PutMapping()
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        return service.updateOrder(order);
    }

    @DeleteMapping()
    public void deleteOrder(@RequestBody Order order) {
        service.deleteOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable("id") int id) {
        service.deleteOrderbyID(id);
    }

}
