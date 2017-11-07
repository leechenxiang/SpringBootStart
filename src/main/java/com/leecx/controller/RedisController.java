package com.leecx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leecx.pojo.LeeJSONResult;
import com.leecx.pojo.User;
import com.leecx.utils.JsonUtils;
import com.leecx.utils.RedisOperator;

@RestController
@RequestMapping("redis")
public class RedisController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisOperator jedis;
	
	@RequestMapping("/test")
	public LeeJSONResult test() {
		
		stringRedisTemplate.opsForValue().set("springboot-redis", "hello~~~");
		
		return LeeJSONResult.ok(stringRedisTemplate.opsForValue().get("springboot-redis"));
	}
	
	@RequestMapping("/test2")
	public LeeJSONResult test2() {
		
		jedis.set("use-jedis-in-springboot", "hello jedis operator~~~", 1000);
		
		String value = jedis.get("use-jedis-in-springboot");
		long expire = jedis.ttl("use-jedis-in-springboot");
		
		return LeeJSONResult.ok("jedis中的值为：" + value + ", 剩余时间ttl为：" + expire);
	}
	
	@RequestMapping("/getJsonObject")
	public LeeJSONResult getJsonObject() {
		
		User user = new User();
		user.setAge(18);
		user.setName("lee");
		user.setPassword("123456");
		user.setBirthday(new Date());
		
		jedis.set("json:info:user", JsonUtils.objectToJson(user), 2000);
		
		String userJson = jedis.get("json:info:user");
		User userBorn = JsonUtils.jsonToPojo(userJson, User.class);
		
		return LeeJSONResult.ok(userBorn);
	}
	
	@RequestMapping("/getJsonList")
	public LeeJSONResult getJsonList() {
		
		User user = new User();
		user.setAge(18);
		user.setName("lee");
		user.setPassword("123456");
		user.setBirthday(new Date());
		
		User u1 = new User();
		u1.setAge(19);
		u1.setName("itzixi");
		u1.setPassword("123456");
		u1.setBirthday(new Date());
		
		User u2 = new User();
		u2.setAge(17);
		u2.setName("LeeCX");
		u2.setPassword("123456");
		u2.setBirthday(new Date());
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(u1);
		userList.add(u2);
		
		
		jedis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);
		
		String userListJson = jedis.get("json:info:userlist");
		List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);
		
		return LeeJSONResult.ok(userListBorn);
	}
}