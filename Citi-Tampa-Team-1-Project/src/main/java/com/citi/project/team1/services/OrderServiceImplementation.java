package com.citi.project.team1.services;

import com.citi.project.team1.entities.Order;
import com.citi.project.team1.repos.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService {

    private static final Logger logger = LogManager.getLogger(OrderServiceImplementation.class);

    @Autowired
    private OrderRepository dao;



    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<Order> getAllOrders(){
        logger.info("getting the catalog");

        return dao.findAll();
    }

    @Override
    public Order getOrderByID(int id){
        Optional<Order> OrderOptional =  dao.findById(id);
        if (OrderOptional.isPresent()) {
            return OrderOptional.get();
        }
        else return null;
    }
    @Override
    public Order addNewOrder(Order order){

        return dao.save(order);
    }
    @Override
    public void deleteOrderbyID(int id){
        Order toBeDeleted = dao.findById(id).get();
        deleteOrder(toBeDeleted);

    }
    @Override
    public void deleteOrder(Order order){
        dao.delete(order);

    }
    @Override
    public Order updateOrder(Order order){
        return dao.save(order);
    }
}
