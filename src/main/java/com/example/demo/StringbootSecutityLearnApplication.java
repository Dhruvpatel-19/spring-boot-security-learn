package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@SpringBootApplication
public class StringbootSecutityLearnApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(StringbootSecutityLearnApplication.class, args);
		System.out.println("App Started..");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user1 = new User();
		user1.setUsername("AAA");
		user1.setPassword(this.bcryptPasswordEncoder.encode("111"));
		user1.setEmail("AAA@gmail.com");
		user1.setRole("ROLE_ADMIN");
		
		this.userRepository.save(user1);
		
		User user2 = new User();
		user2.setUsername("BBB");
		user2.setPassword(this.bcryptPasswordEncoder.encode("111"));
		user2.setEmail("BBB@gmail.com");
		user2.setRole("ROLE_NORMAL");
		
		this.userRepository.save(user2);
	}
	
	
}
