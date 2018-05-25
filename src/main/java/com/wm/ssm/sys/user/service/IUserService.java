package com.wm.ssm.sys.user.service;

import java.util.List;

import com.wm.ssm.sys.user.model.TbSysUser;
import com.wm.ssm.sys.user.vo.UserVO;

public interface IUserService {
	
	TbSysUser getById(String userId);

	List<TbSysUser> getList();

	int updateUserStatus(String userId);

	UserVO searchUserVOById(String userId);

}
