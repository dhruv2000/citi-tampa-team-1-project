package com.citi.project.team1.services;

import com.citi.project.team1.entities.Order;
import com.citi.project.team1.entities.StockData;
import com.citi.project.team1.repos.OrderRepository;
import io.swagger.models.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.util.Arrays;
import java.util.List;
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
//        if(order.getStatus_code() != 0){
//            //Throw an error because the status code is invalid
//        }else{
//            //Update the status code to 1 and save in database
//        }

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

    // TODO: Need to implement Update Order By ID
    @Override
    public ResponseEntity<Order> updateOrder(Order order){
        ResponseEntity<Order> responseEntitySuccess = new ResponseEntity<>(order, HttpStatus.OK);
        ResponseEntity<Order> responseEntityFail = new ResponseEntity<>(HttpStatus.OK);
        Optional<Order> orderToUpdate = dao.findById(order.getId());
        if(orderToUpdate.isPresent()){
            dao.save(order);
            return responseEntitySuccess;
        }else{
            return responseEntityFail;
        }
    }


//    TODO: Finish this function
    @Override
    public StockData updateOrderStatuses() {
        System.out.println("Made it here");
        RestTemplate restTemplate = new RestTemplate();
        String getTickerDataURL
                = "https://3p7zu95yg3.execute-api.us-east-1.amazonaws.com/default/priceFeed2?ticker=TSLA&num_days=2";
        StockData response
                = restTemplate.getForObject(getTickerDataURL, StockData.class);
        assert response != null;

        Double price = response.getPrice_data()[0].getValue();

        // Grab the data from the database, and go through it--- if data is from current day, THEN make status changes
        //Also think about what gets added for status code as a default
//        assert response != null;
//        System.out.println(response.getTicker());
//        System.out.println(Arrays.toString(response.getPrice_data()));
//        for (StockData.StockInfo obj :
//                response.getPrice_data()) {
//            System.out.println(obj);
//        }
//        assert response.getStatusCode() == HttpStatus.OK;
//        return response.getBody();
    return response;
    }

    @Override
    public List<Order> findByTicker(String ticker) {
        return dao.findByTicker(ticker);
    }
}
