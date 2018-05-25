package com.wm.ssm.sys.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wm.ssm.sys.user.model.TbSysUser;
import com.wm.ssm.sys.user.vo.UserVO;

public interface UserDAO {
	
	/**
	 * 通过ID查询用户
	 * @param userId
	 * @return
	 */
	TbSysUser queryById(String userId);

	/**
	 * 查询所有用户
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 * @return
	 */
	List<TbSysUser> queryAll(@Param("offset") int offset, @Param("limit") int limit);

	/**
	 * 更新用户状态
	 * @param userId
	 * @param status
	 * @return
	 */
	int updateUserStatus(String userId,boolean status);
	
	UserVO queryUserVOById(String userId);
}
