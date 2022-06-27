package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;


@Service
public class UserService {
	List<User> list = new ArrayList<>();

	public UserService() {
		list.add(new User("AAA" , "111" , "AAA@gmail.com"));
		list.add(new User("BBB" , "222", "BBB@gmail.com"));
	}
	
	//get all users
	public List<User> getAllUsers(){
		return list;
	}
	
	//get single user
	public User getUser(String uname) {
		return this.list.stream().filter(user -> user.getUsername().equals(uname)).findAny().orElse(null);
	}
	
	//add new user
	public User addUser(User user) {
		list.add(user);
		return user;
	}
}
