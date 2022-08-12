package com.citi.project.team1.rest;

import com.citi.project.team1.entities.Order;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.OrderService;

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
        return service.getALLOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") int id) {
        return service.getOrderByID(id);
    }

    //    @RequestMapping (method = RequestMethod.POST)
    @PostMapping()
    public void addOrder(@RequestBody Order order){
        service.addNewOrder(order);
    }

    @PutMapping()
    public void updateOrder(@RequestBody Order order){
        service.updateOrder(order);
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
