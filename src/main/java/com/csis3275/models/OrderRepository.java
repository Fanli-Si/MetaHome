package com.csis3275.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByQuantity(int quantity);
	List<Order> findByTotalCost(int totalCost);
	List<Order> findByUserId(int userId);
}
