package com.csis3275.demo;

import org.springframework.boot.ApplicationRunner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.csis3275.demo.model.Order;
import com.csis3275.demo.model.OrderRepository;
import com.csis3275.demo.model.User;
import com.csis3275.demo.model.UserRepository;


@SpringBootApplication
public class MetaHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetaHomeApplication.class, args);
	}

	@Bean
	ApplicationRunner init(OrderRepository orderRepository, 
			UserRepository userRepository) {
		return args -> {

			Order[] orders = { 
					new Order("CSIS2175", 0, "Advanced integrated software development", null, 0),
					new Order("CSIS3275", 0, "Software engineering", null, 0), 
					new Order("CSIS1190", 0, "Excel for business", null, 0) };

			
			User[] users = { 
					new User("03123456", "Simon Li", "123456"),
					new User("03456789", "Ivan Wong", "123456") };

			users[0].addOrder(orders[0]);
			users[0].addOrder(orders[1]);

			for (int i = 0; i < orders.length; i++) {
				orderRepository.save(orders[i]);
			}
			
			for (int i = 0; i < users.length; i++) {
				userRepository.save(users[i]);
			}

			orderRepository.findAll().forEach(System.out::println);
			userRepository.findAll().forEach(System.out::println);

		};

	}

}
