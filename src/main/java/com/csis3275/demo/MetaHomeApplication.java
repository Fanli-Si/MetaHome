package com.csis3275.demo;

import java.text.SimpleDateFormat;

import org.springframework.boot.ApplicationRunner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.csis3275.demo.model.Category;
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
					new Order("1234", ft.parse("2022-04-10"), "112233", true, 30.27),
					new Order("1235", ft.parse("2022-04-11"), "112244", true, 22.84), 
					new Order("1236", ft.parse("2022-04-12"), "112255", false, 11.90)};

			
			User[] users = { 
					new User("300321101", "Hyukjoo Lee", "1234"),
					new User("03456789", "Ivan Wong", "123456") };
			
			Category[] cats = {
					new Category("Home Cleaning"),
					new Category("Bathroom"),
					new Category("Kitchen"),
					new Category("Pet"),
					new Category("Food")
			};
			
			Item[] items = {
					new Item("Paper Towel", 10.00,"Cleaning, Wipe", 24),
					new Item("Toilet Paper", 10.00, "Toilet, Hygene", 24),
					new Item("All Purpose Cleaner", 5.00,"Cleaner, Spray",24),
					new Item("Hand Soap", 3.25, "Soap, Hygene",24),
					new Item("Dish Soap", 7.00, "Soap, Dishes",24),
					new Item("Kitty Litter", 15.00, "Cat, Litter",24),
					new Item("Dry Dog Food", 13.25, "Dog",24),
					new Item("Wet Dog Food", 20,"Dog",12),
					new Item("Dry Cat Food", 13.25,"Cat",24),
					new Item("Wet Cat Food", 20,"Cat",12),
					new Item("Pet Waste Baggie", 4.15,"Litter",24),
					new Item("Laundry Deturgent", 19.95,"Laundry, Cleaning",24),
					new Item("Fabric Softener", 6.25,"Laundry",24),
					new Item("Salt", 3.25, "Cooking, Herbs and Spices",24),
					new Item("Black Pepper", 3.25, "Cooking, Herbs and Spices",24),
					new Item("Shampoo", 6.00,"Hygene, Shower",24),
					new Item("Conditioner", 6.00,"Hygene, Shower",24),
					new Item("Body Wash", 5.50,"Hygene, Shower",24),
					new Item("Bleach", 10.00,"Cleaning",24),
					new Item("Mop Cleaner",7.00,"Cleaning, Floors" ,24),
					new Item("Cheddar Cheese", 8.40, "Cheese, Food, Dairy",1),
					new Item("Swiss Cheese",  8.25, "Cheese, Food, Dairy",1),
					new Item("Garlic Bulb", 0.20, "Food, Herb, Cooking",1),
					new Item("Milk 4L", 5.25, "Dairy, Food",0.25),
					new Item("Milk 1L",3.50,"Dairy,Food",0.25),
					new Item("Basmatti Rice", 12.00,"Food, Rice, Cooking",12),
					new Item("Jasmine Rice", 12.00, "Food, Rice, Cooking",12),
					new Item("Granny Smith Apple", 0.45,"Fruit, Food, Apple",0.25),
					new Item("Gala Apple", 0.45, "Fruit, Food, Apple",0.25),
					new Item("Toothpaste", 2.50, "Teeth, Bathroom, Hygene",24),
					new Item("Mouthwash", 4.00, "Teeth, Bathroom, Hygene",24),
					new Item("Floss", 2.20,"Teeth, Bathroom, Hygene",24),
					new Item("Toothbrush", 3.00, "Teeth, Bathroom, Hygene",24),
					new Item("Ground Ginger", 2.50, "Food, Herbs and Spices, Cooking",12),
					new Item("Tumeric", 2.50, "Food, Herbs and Spices, Cooking",12),
					new Item("Cayanne Pepper",2.50,"Food, Herbs and Spices, Cooking",12),
					new Item("Siracha", 4.20, "Food, Cooking, Condiments",12),
					new Item("Mayo", 5.20, "Food, Condiments",6),
					new Item("Ketchup", 5.00, "Food, Condiments",6),
					new Item("Ground Beef", 7.25,"Food, Meat, Raw, Beef, Cooking",0.25),
					new Item("White Bread", 3.00,"Food, Bakery, Bread",0.25),
					new Item("Whole Wheat Bread", 3.00, "Food, Bakery, Bread",0.25),
					new Item("Sourdough Bread", 3.00, "Food, Bakery, Bread",0.25),
					new Item("Coke - 24 Pack", 9.99, "Drink, Coke, Soda, Cans",24),
					new Item("Pepsi - 24 Pack", 9.99, "Drink, Pepsi, Soda, Cans",24),
					new Item("Dr.Pepper - 24 Pack", 9.99, "Drink, Dr.Pepper, Soda, Cans",24),
					new Item("Coke - 2L",  3.75, "Drink, Coke, Soda",24),
					new Item("Nestea - 2L", 3.75, "Drink, Iced Tea, Soda",24),
					new Item("12 Eggs - Large", 4.40, "Food, Eggs, Cooking",0.5)
					
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
