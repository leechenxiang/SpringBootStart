package com.leecx.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.LeeJSONResult;
import com.pojo.User;

@RestController
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String Hello() {
		
		return "Hello Spring Boot~";
	}
	
	@RequestMapping("/getJSON")
	public LeeJSONResult getJSON() {
		
		User user = new User();
		user.setAge(18);
		user.setName("lee");
		user.setPassword("123456");
		user.setBirthday(new Date());
		
		return LeeJSONResult.ok(user);
	}
	
	@RequestMapping("/getUser")
	public User getUser() {
		
		User user = new User();
		user.setAge(18);
		user.setName("lee");
		user.setPassword("123456");
		user.setBirthday(new Date());
		
		user.setName("lee123");
		
		return user;
	}
	
	@RequestMapping("/reload")
	public String reload() {
		
		return "I am reloading...";
	}
}
