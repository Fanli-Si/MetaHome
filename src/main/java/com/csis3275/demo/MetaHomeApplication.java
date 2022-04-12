package com.csis3275.demo;

import java.text.SimpleDateFormat;

import org.springframework.boot.ApplicationRunner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.csis3275.demo.model.Item;
import com.csis3275.demo.model.ItemRepository;
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
			UserRepository userRepository, ItemRepository itemRepository) {
		return args -> {
			
			SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");

			Order[] orders = { 
					new Order("1234", 1, "item1", ft.parse("2022-04-10"), 112233),
					new Order("1235", 2, "item2", ft.parse("2022-04-11"), 112244), 
					new Order("1236", 3, "item3", ft.parse("2022-04-12"), 112255) };

			
			User[] users = { 
					new User("300321101", "Hyukjoo Lee", "1234"),
					new User("03456789", "Ivan Wong", "123456") };
			
			Item[] items = {
					new Item("Paper Towel", "Home Cleaning", 10.00,"Cleaning, Wipe"),
					new Item("Toilet Paper", "Bathroom", 10.00, "Toilet, Hygene"),
					new Item("All Purpose Cleaner", " Home Cleaning", 5.00,"Cleaner, Spray"),
					new Item("Hand Soap", "Bathroom", 3.25, "Soap, Hygene"),
					new Item("Dish Soap", "Kitchen", 7.00, "Soap, Dishes"),
					new Item("Kitty Litter","Pet", 15.00, "Cat, Litter"),
					new Item("Dry Dog Food", "Pet", 13.25, "Dog"),
					new Item("Wet Dog Food", "Pet", 20,"Dog"),
					new Item("Dry Cat Food", "Pet", 13.25,"Cat"),
					new Item("Wet Cat Food", "Pet", 20,"Cat"),
					new Item("Pet Waste Baggie", "Pet", 4.15,"Litter"),
					new Item("Laundry Deturgent", "Home Cleaning", 19.95,"Laundry, Cleaning"),
					new Item("Fabric Softener", "Home Cleaning", 6.25,"Laundry"),
					new Item("Salt", "Food", 3.25, "Cooking, Herbs and Spices"),
					new Item("Black Pepper", "Food", 3.25, "Cooking, Herbs and Spices"),
					new Item("Shampoo", "Bathroom", 6.00,"Hygene, Shower"),
					new Item("Conditioner", "Bathroom", 6.00,"Hygene, Shower"),
					new Item("Body Wash","Bathroom",5.50,"Hygene, Shower"),
					new Item("Bleach","Home Cleaning", 10.00,"Cleaning"),
					new Item("Mop Cleaner","Home Cleaning", 7.00,"Cleaning, Floors" ),
					new Item("Cheddar Cheese", "Food", 8.40, "Cheese, Food, Dairy"),
					new Item("Swiss Cheese", "Food", 8.25, "Cheese, Food, Dairy"),
					new Item("Garlic Bulb", "Food", 0.20, "Food, Herb, Cooking"),
					new Item("Milk 4L", "Food", 5.25, "Dairy, Food"),
					new Item("Milk 1L","Food",3.50,"Dairy,Food"),
					new Item("Basmatti Rice", "Food", 12.00,"Food, Rice, Cooking"),
					new Item("Jasmine Rice", "Food", 12.00, "Food, Rice, Cooking")
			};

			users[0].addOrder(orders[0]);
			users[0].addOrder(orders[1]);

			for (int i = 0; i < orders.length; i++) {
				orderRepository.save(orders[i]);
			}
			
			for (int i = 0; i < users.length; i++) {
				userRepository.save(users[i]);
			}
			
			for (int i = 0; i < items.length; i++) {
				itemRepository.save(items[i]);
			}

			orderRepository.findAll().forEach(System.out::println);
			userRepository.findAll().forEach(System.out::println);

		};

	}

}
