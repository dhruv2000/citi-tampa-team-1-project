package com.citi.project.team1.repo;


import com.citi.project.team1.AppConfig;
import com.citi.project.team1.entities.Order;
import com.citi.project.team1.repos.OrderRepository;
import com.citi.project.team1.rest.OrderController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest // use an in memory database
@ContextConfiguration(classes= AppConfig.class)
@TestPropertySource(locations = "classpath:application-test.properties") // this is only needed because swagger breaks tests
public class TestOrderRepository {

    @Autowired
    private TestEntityManager manager;

    @Autowired // this is a mock which is injected because of the @DataJpaTest
    private OrderRepository repo;

    @Autowired
    private OrderRepository orderService;


    @Autowired
    OrderController controller;

    private int orderId;

    @BeforeEach
    public  void setupDatabaseEntryForReadOnlyTests() {

        Order order = new Order("buy", 12.99, "2022-08-12 14:02:29", "stock", 0, 77, "NET");
        Order result = manager.persist(order);
        orderId = result.getId();

    }


    // unit test the repo using a mock database
    @Test
    public void canRetrieveOrdersByTicker() {
        List<Order> orders = repo.findByTicker("NET");
        assertThat(orders.size(), equalTo(1));
    }


    // integration test for the service layer and data layer
    @Test
    public void orderServiceCanReturnAllOrders() {
        List<Order> discs = orderService.findAll();
//        Stream<CompactDisc> stream = StreamSupport.stream(discs.spliterator(), false);
//        Optional<CompactDisc> firstDisc = stream.findFirst();
        assertThat(discs.get(0).getTicker(), equalTo("NET"));
    }
//
    // integration test with the controller
    @Test
    public void controllerCanReturnOrderById() {
        Order order = controller.getOrderById(1);

        assertThat(order.getTicker(), equalTo("NET"));
    }
}
