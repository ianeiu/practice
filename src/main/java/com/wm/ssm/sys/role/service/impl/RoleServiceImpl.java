package com.wm.ssm.sys.role.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wm.ssm.sys.role.dao.TbSysRoleMapper;
import com.wm.ssm.sys.role.model.TbSysRole;
import com.wm.ssm.sys.role.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService{

	@Resource
	private TbSysRoleMapper tbSysRoleMapper;
	
	@Override
	public int addRole(TbSysRole sr) {
		return tbSysRoleMapper.insert(sr);
	}

	
}
