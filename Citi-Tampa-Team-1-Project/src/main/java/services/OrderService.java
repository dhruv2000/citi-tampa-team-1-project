package services;

import com.citi.project.team1.entities.Order;

import java.util.List;

public interface OrderService {



        Iterable<Order> getAllOrders();

        Order getOrderByID(int id);

        Order addNewOrder(Order order);

        void deleteOrderbyID(int id);

        void deleteOrder(Order order);

        Order updateOrder(Order order);

}
