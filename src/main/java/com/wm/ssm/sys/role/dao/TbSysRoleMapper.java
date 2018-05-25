package com.wm.ssm.sys.role.dao;

import com.wm.ssm.sys.role.model.TbSysRole;

public interface TbSysRoleMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(TbSysRole record);

    int insertSelective(TbSysRole record);

    TbSysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbSysRole record);

    int updateByPrimaryKey(TbSysRole record);
}