package com.csis3275;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	ApplicationRunner init(UserRepository repository) {
		return args ->{
			repository.save(new User("Kadyn", "Neale", "xxxx Unknown St", "randomEmail@email.com", 666666666));
			repository.save(new User("King", "K.Rule", "xxxx Kong Isle", "KingKrule@email.com", 666666666));
			repository.save(new User("Monkey", "D.Luffy", "xxxx Thousad Sunny", "Gomugomu@email.com", 666666666));
			repository.save(new User("Luigi", "Luigi", "xxxx Mushroom Kingdom", "LuigiTime@email.com", 666666666));
		};
	}
	
	ApplicationRunner init(RegisteryformatRepository repository) {
		return args -> {

			repository.save(new Registeryformat("Lee", "Last Name",30 ,"Lee@yahoo.com","Omar33","123456"));
			repository.save(new Registeryformat("Fainl", "Last Name",30 ,"Fainl@yahoo.com","Omar33","123456"));
			repository.save(new Registeryformat("Kidny", "Last Name",30 ,"Kidny@yahoo.com","Omar33","123456"));
			repository.save(new Registeryformat("Omar", "Al-khazraji",30 ,"omarheader@yahoo.com","Omar33","123456"));
			repository.findAll().forEach(System.out::println);
		};
	}
	
}
