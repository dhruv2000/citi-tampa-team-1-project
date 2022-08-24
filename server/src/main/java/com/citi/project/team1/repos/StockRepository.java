package com.citi.project.team1.repos;

import com.citi.project.team1.entities.Order;
import com.citi.project.team1.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StockRepository extends JpaRepository<Stock,Integer>, CrudRepository<Stock, Integer> {

    public Stock findByTicker(String ticker);


}
