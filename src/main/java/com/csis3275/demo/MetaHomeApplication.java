package com.csis3275.demo;

import java.text.SimpleDateFormat;

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
			
			SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");

			Order[] orders = { 
					new Order("1234", 1, "item1", ft.parse("2022-04-10"), 112233),
					new Order("1235", 2, "item2", ft.parse("2022-04-11"), 112244), 
					new Order("1236", 3, "item3", ft.parse("2022-04-12"), 112255) };

			
			User[] users = { 
					new User("300321101", "Hyukjoo Lee", "1234"),
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
