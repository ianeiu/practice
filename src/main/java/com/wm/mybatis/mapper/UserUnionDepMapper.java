package com.wm.mybatis.mapper;

import java.util.List;

import com.wm.mybatis.model.TbSysUserVO;

public interface UserUnionDepMapper {

	TbSysUserVO getUserByUserId(String id);
	
	TbSysUserVO getUserByUserIdStep(String id);

	List<TbSysUserVO> getUserListByDepId(String depId);
}
