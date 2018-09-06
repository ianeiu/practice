package com.wm.demo.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

import com.wm.demo.mybatis.model.TbSysUser;

public interface UserAnnotationMapper {
	
	@Select("select * from tb_sys_user where user_id = #{id}")
	TbSysUser getUserById(String id);

}
