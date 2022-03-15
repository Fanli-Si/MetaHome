package com.csis3275;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.csis3275.models.Item;
import com.csis3275.models.ItemRepository;
import com.csis3275.models.LoginFormat;
import com.csis3275.models.LoginformatRepository;
import com.csis3275.models.Order;
import com.csis3275.models.OrderRepository;
import com.csis3275.models.Registeryformat;
import com.csis3275.models.RegisteryformatRepository;
import com.csis3275.models.User;
import com.csis3275.models.UserRepository;


@SpringBootApplication
public class MHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MHomeApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(UserRepository repository, RegisteryformatRepository repository2, LoginformatRepository repository3
			, ItemRepository repository4, OrderRepository repository5) {
		return args ->{
			repository.save(new User("Kadyn", "Neale", "xxxx Unknown St", "randomEmail@email.com", 666666666));
			repository.save(new User("King", "K.Rule", "xxxx Kong Isle", "KingKrule@email.com", 666666666));
			repository.save(new User("Monkey", "D.Luffy", "xxxx Thousad Sunny", "Gomugomu@email.com", 666666666));
			repository.save(new User("Luigi", "Luigi", "xxxx Mushroom Kingdom", "LuigiTime@email.com", 666666666));
			
			repository2.save(new Registeryformat("Lee", "Last Name",30 ,"Lee@yahoo.com","Omar33","123456"));
			repository2.save(new Registeryformat("Fainl", "Last Name",30 ,"Fainl@yahoo.com","Omar33","123456"));
			repository2.save(new Registeryformat("Kidny", "Last Name",30 ,"Kidny@yahoo.com","Omar33","123456"));
			repository2.save(new Registeryformat("Omar", "Al-khazraji",30 ,"omarheader@yahoo.com","Omar33","123456"));
			
			repository3.save(new LoginFormat("Monkey", "1234"));
			repository3.save(new LoginFormat("Dog", "1234"));
			
			repository4.save(new Item("banana", "grocery", 5));
			repository4.save(new Item("detergent", "laundary", 10));
			repository4.save(new Item("tissue", "everyday", 10));
			
			repository4.save(new Item("banana", "grocery", 5));
			repository4.save(new Item("detergent", "laundary", 10));
			repository4.save(new Item("tissue", "everyday", 10));
			
			repository5.save(new Order(1, 2, 13, new int[3]));
			repository5.save(new Order(3, 16, 242, new int[4]));
			
			
		};
	}
	

}
