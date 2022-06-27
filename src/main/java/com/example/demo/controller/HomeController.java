package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/public")
public class HomeController {
	
	@GetMapping("/home")
	public String Home() {
		return "Home Page";
	}
	
	@GetMapping("/login")
	public String Login() {
		return "Login Page";
	}
	
	@GetMapping("/register")
	public String Register() {
		return "Register Page";
	}
}
