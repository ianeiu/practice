package com.wm.ssm.sys.user.service;

import java.util.List;

import com.wm.ssm.sys.user.model.SysUserBean;

public interface IUserService {
	
	SysUserBean getById(String userId);

	List<SysUserBean> getList();

	int updateUserStatus(String userId);

}
