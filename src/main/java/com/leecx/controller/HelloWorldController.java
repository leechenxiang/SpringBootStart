package com.leecx.controller;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leecx.pojo.ConfigResource;
import com.leecx.pojo.LeeJSONResult;
import com.leecx.pojo.User;

@RestController
public class HelloWorldController {
	
//	@Value("${leecx.itzixi.website}")
//	private String itzixiWebSite;
	
	@Autowired
	public ConfigResource config;
	
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
	
//	@RequestMapping("/itzixiWebSite")
//	public String itzixiWebSite() {
//		
//		return itzixiWebSite;
//	}
	
	@RequestMapping("/getConfig")
	public LeeJSONResult getConfig() {
		
		ConfigResource bean = new ConfigResource();
		BeanUtils.copyProperties(config, bean);
		
		return LeeJSONResult.ok(bean);
	}
	
	@RequestMapping("/showerror")
	public String error() {
		
		int a = 1 / 0;
		
		return "" + a;
	}

}
