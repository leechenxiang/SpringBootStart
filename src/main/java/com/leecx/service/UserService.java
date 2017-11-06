package com.leecx.service;

import java.util.List;

import com.leecx.pojo.SysUser;
import com.leecx.utils.JqGridResult;

public interface UserService {

	public void saveUser(SysUser user);
	
	public void updateUser(SysUser user);
	
	public void deleteUser(String userId);
	
	public SysUser queryUserById(String userId);
	
	public List<SysUser> queryUserList(SysUser user);
	
	public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);
	
	public JqGridResult queryUserListPagedJqgrid(SysUser user, Integer page, Integer pageSize);
	
	public SysUser queryUserByIdCustom(String userId);
}
