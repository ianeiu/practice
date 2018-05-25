package com.wm.ssm.sys.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wm.ssm.sys.user.dao.UserDAO;
import com.wm.ssm.sys.user.model.SysUserBean;
import com.wm.ssm.sys.user.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Resource
	private UserDAO userDAO;
	
	@Override
	public SysUserBean getById(String userId) {
		return userDAO.queryById(userId);
	}

	@Override
	public List<SysUserBean> getList() {
		return userDAO.queryAll(0,10);
	}

	@Override
	public int updateUserStatus(String userId) {
		SysUserBean bean = userDAO.queryById(userId);
		boolean s = bean.isStatus();
		return userDAO.updateUserStatus(userId, !s);
	}
	
}
