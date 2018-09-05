package com.wm.demo.mybatis.abase;

import org.apache.ibatis.annotations.Select;

public interface UserAnnotationMapper {
	
	@Select("select * from tb_sys_user where user_id = #{id}")
	TbSysUser getUserById(String id);

}
