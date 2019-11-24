package com.wm.mybatis.mapper;

import java.util.List;

import com.wm.mybatis.model.TbSysUser;
import org.apache.ibatis.annotations.Param;

public interface UserDynamicMapper {
	
	List<TbSysUser> getUsersDealParam(TbSysUser user);
	
	//携带了哪个字段查询条件就带上这个字段的值
	List<TbSysUser> getUsersByConditionIf(TbSysUser user);
	
	List<TbSysUser> getUsersByConditionTrim(TbSysUser user);
	
	List<TbSysUser> getUsersByConditionChoose(TbSysUser user);
	
	void updateUser(TbSysUser user);
	
	List<TbSysUser> getUsersByConditionForeach(@Param("ids")List<String> ids);
	
	void addUsers(@Param("users")List<TbSysUser> users);
}
