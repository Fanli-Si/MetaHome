package com.csis3275.demo.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csis3275.demo.model.Order;
import com.csis3275.demo.model.OrderRepository;
import com.csis3275.demo.request.OrderRequest;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;

	@GetMapping("/order/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") long id) {
		Optional<Order> orderData = orderRepository.findById(id);

		if (orderData.isPresent()) {
			return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/order")
	public ResponseEntity<List<Order>> getAllOrders(@RequestParam(required = false) String title) {

		try {
			List<Order> orders = new ArrayList<Order>();
			if (title == null) {
				orderRepository.findAll().forEach(orders::add);
			} 
			return new ResponseEntity<>(orders, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PutMapping("/{orderID}/checkout")
	public ResponseEntity<?> addOrder(@PathVariable("orderID") Long orderID, @Valid @RequestBody OrderRequest orderRequest){
		try {
			Order _order = orderRepository.save(new Order(orderRequest.getUserID(), orderRequest.getAction(), null, null, 0)); 
			return new ResponseEntity<>(_order,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR); 
		}

	}


}



