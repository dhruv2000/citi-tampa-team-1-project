package services;

import com.citi.project.team1.entities.Order;

public interface OrderService {



        Iterable<Order> getALLOrders();

        Order getCompactDiscByID(int id);

        Order addNewOrder(Order order);

        void deleteOrderbyID(int id);

        void deleteOrder(Order order);

        Order updateOrder(Order order);

}
