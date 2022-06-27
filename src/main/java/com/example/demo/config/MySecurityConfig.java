package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.CustomDetailService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomDetailService customDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//Basic Authentication 
		//Form Based Authentication
		http
			.csrf().disable()
			.authorizeRequests()
			 //.antMatchers("/home", "/login" , "/register").permitAll()
			//.antMatchers("/public/**").permitAll()
			.antMatchers("/public/**").hasRole("NORMAL")
			.antMatchers("/users/**").hasRole("ADMIN")
			.anyRequest().authenticated().and()
			//.httpBasic();
			.formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("AAA").password(this.passwordEncoder().encode("111")).roles("NORMAL");
		//auth.inMemoryAuthentication().withUser("BBB").password(this.passwordEncoder().encode("111")).roles("ADMIN");
		auth.userDetailsService(customDetailService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder() ;
	}
	

}
