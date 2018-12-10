package com.wm.demo.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.wm.demo.mybatis.model.OraclePage;
import com.wm.demo.mybatis.model.TbSysUser;

public interface UserMapper {

	// -----------------------------------------------------------BASE
	TbSysUser getUserById(String id);

	// -----------------------------------------------------------CUD

	// int 1
	// boolean true
	boolean addUser(TbSysUser user);

	boolean updateUser(TbSysUser user);

	void deleteUserById(String id);

	// -----------------------------------------------------------SelectParam

	// 多条记录封装一个map：Map<Integer,TbSysUser>:键是这条记录的主键，值是记录封装后的javaBean
	// @MapKey:告诉mybatis封装这个map的时候使用哪个属性作为map的key
	@MapKey("userName")
	Map<String, TbSysUser> getUserMapByUserName(String userName);

	// 返回一条记录的map；key就是列名，值就是对应的值
	Map<String, Object> getUserMapByUserId(String id);

	List<TbSysUser> getUserListByUserName(String userName);

	TbSysUser getUserByMap(Map<String, Object> map);

	TbSysUser getUserByIdAndName(String id, String userName);

	TbSysUser getUserAnnoationByIdAndName(@Param("id") String id, @Param("userName") String userName);

	void getUserPageByProcedure(OraclePage<TbSysUser> page);
}
