package com.csis3275.demo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findByOrderNumber(String order_number);
	List<Order> findByOrderDate(Date order_date);
	List<Order> findByStatus(boolean isClose);
	
}
