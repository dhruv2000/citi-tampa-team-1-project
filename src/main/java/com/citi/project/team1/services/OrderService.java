package com.citi.project.team1.services;

import com.citi.project.team1.entities.Order;
import com.citi.project.team1.entities.Stock;
import com.citi.project.team1.entities.StockData;
import io.swagger.models.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface OrderService {

        Iterable<Order> getAllOrders();
        Iterable<Order> getAllProcessedOrders();

        Order getOrderByID(int id);

        Order addNewOrder(Order order);

        void deleteOrderbyID(int id);

        void deleteOrder(Order order);

        ResponseEntity<Order> updateOrder(Order order);

        StockData updateOrderStatuses();

        List<Order> findByTicker(String ticker);

}
