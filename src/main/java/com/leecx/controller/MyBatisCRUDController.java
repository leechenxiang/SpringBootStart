package com.leecx.controller;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leecx.pojo.LeeJSONResult;
import com.leecx.pojo.SysUser;
import com.leecx.service.UserService;
import com.leecx.utils.JqGridResult;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public LeeJSONResult saveUser() {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("lee" + new Date());
		user.setNickname("lee" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return LeeJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public LeeJSONResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("171106BFRN1WZYA8");
		user.setUsername("mybatisUser" + new Date());
		user.setNickname("mybatisUser" + new Date());
		user.setPassword("mybatisUser");
		
		userService.updateUser(user);
		
		return LeeJSONResult.ok("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public LeeJSONResult deleteUser() {
		
		userService.deleteUser("171020FXMC68W1YW");
		
		return LeeJSONResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public LeeJSONResult queryUserById() {
		
		return LeeJSONResult.ok(userService.queryUserById("171106BFRN1WZYA8"));
	}
	
	@RequestMapping("/queryUserList")
	public LeeJSONResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("mybatisUserMon Nov 06 16:11:44 CST 2017");
//		user.setNickname("itzixi");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return LeeJSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public LeeJSONResult queryUserListPaged(Integer page) {
		
		if (page == null) {
			page = 1;
		}

		int pageSize = 2;
		
		SysUser user = new SysUser();
//		user.setUsername("mybatisUserMon Nov 06 16:11:44 CST 2017");
//		user.setNickname("itzixi");
		
		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
		
		return LeeJSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserListPagedJqgrid")
	public LeeJSONResult queryUserListPagedJqgrid(Integer page) {
		
		if (page == null) {
			page = 1;
		}

		int pageSize = 2;
		
		SysUser user = new SysUser();
//		user.setUsername("mybatisUserMon Nov 06 16:11:44 CST 2017");
//		user.setNickname("itzixi");
		
		JqGridResult userList = userService.queryUserListPagedJqgrid(user, page, pageSize);
		
		return LeeJSONResult.ok(userList);
	}
	
	@RequestMapping("/queryUserByIdCustom")
	public LeeJSONResult queryUserByIdCustom() {
		
		return LeeJSONResult.ok(userService.queryUserByIdCustom("171106BFRN1WZYA8"));
	}
	
	@RequestMapping("/saveUserTransactional")
	public LeeJSONResult saveUserTransactional() {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("lee" + new Date());
		user.setNickname("lee" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUserTransactional(user);
		
		return LeeJSONResult.ok("保存成功");
	}
}
