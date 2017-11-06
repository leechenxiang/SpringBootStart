package com.leecx.mapper;

import java.util.List;

import com.leecx.pojo.SysUser;

public interface SysUserMapperCustom {
	List<SysUser> queryUserSimplyInfoById(String id);
}