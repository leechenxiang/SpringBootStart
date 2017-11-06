package com.leecx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leecx.mapper.SysUserMapper;
import com.leecx.mapper.SysUserMapperCustom;
import com.leecx.pojo.SysUser;
import com.leecx.service.UserService;
import com.leecx.utils.JqGridResult;

import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private SysUserMapperCustom userMapperCustom;
	
	@Override
	public void saveUser(SysUser user) {
		userMapper.insert(user);
	}

	@Override
	public void updateUser(SysUser user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void deleteUser(String userId) {
		userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public SysUser queryUserById(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<SysUser> queryUserList(SysUser user) {
		
		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();
		
		if (!StringUtils.isEmptyOrWhitespace(user.getUsername())) {
			criteria.andEqualTo("username", user.getUsername());
		}
		
		if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
			criteria.andLike("nickname", "%" + user.getNickname() + "%");
		}
		
		List<SysUser> userList = userMapper.selectByExample(example);
		
		return userList;
	}

	@Override
	public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
		
        PageHelper.startPage(page, pageSize);
		
		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();
		
		if (!StringUtils.isEmptyOrWhitespace(user.getUsername())) {
			criteria.andEqualTo("username", user.getUsername());
		}
		
		if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
			criteria.andLike("nickname", "%" + user.getNickname() + "%");
		}
		
		List<SysUser> userList = userMapper.selectByExample(example);
		
		return userList;
	}
	
	@Override
	public JqGridResult queryUserListPagedJqgrid(SysUser user, Integer page, Integer pageSize) {
		
        PageHelper.startPage(page, pageSize);
		
		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();
		
		if (!StringUtils.isEmptyOrWhitespace(user.getUsername())) {
			criteria.andEqualTo("username", user.getUsername());
		}
		
		if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
			criteria.andLike("nickname", "%" + user.getNickname() + "%");
		}
		
		List<SysUser> userList = userMapper.selectByExample(example);
		
		PageInfo<SysUser> pageList = new PageInfo<SysUser>(userList);
		
		JqGridResult grid = new JqGridResult();
		grid.setTotal(pageList.getPages());
		grid.setRows(userList);
		grid.setPage(page);
		grid.setRecords(pageList.getTotal());
		
		return grid;
	}
	
	@Override
	public SysUser queryUserByIdCustom(String userId) {
		List<SysUser> list = userMapperCustom.queryUserSimplyInfoById(userId);
		
		if (list != null && !list.isEmpty()) {
			return (SysUser)list.get(0);
		}
		
		return null;
	}

}
