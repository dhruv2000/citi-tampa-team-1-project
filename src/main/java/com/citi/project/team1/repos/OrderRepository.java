package com.citi.project.team1.repos;

import com.citi.project.team1.entities.Order;
import com.citi.project.team1.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    public List<Order> findByTicker(String ticker);

}
