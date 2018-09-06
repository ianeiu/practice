package com.wm.demo.mybatis.mapper;

import com.wm.demo.mybatis.model.TbSysUser;

public interface UserMapper {

	TbSysUser getUserById(String id);
	
	
	
	

	//int 1
	//boolean true
	boolean addUser(TbSysUser user);

	boolean updateUser(TbSysUser user);

	void deleteUserById(String id);

}
