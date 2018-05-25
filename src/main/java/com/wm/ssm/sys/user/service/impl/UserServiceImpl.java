package com.wm.ssm.sys.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wm.ssm.sys.user.dao.UserDAO;
import com.wm.ssm.sys.user.model.TbSysUser;
import com.wm.ssm.sys.user.service.IUserService;
import com.wm.ssm.sys.user.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements IUserService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private UserDAO userDAO;
	
	@Override
	public TbSysUser getById(String userId) {
		return userDAO.queryById(userId);
	}

	@Override
	public List<TbSysUser> getList() {
		return userDAO.queryAll(0,10);
	}

	@Override
	public int updateUserStatus(String userId) {
		TbSysUser bean = userDAO.queryById(userId);
		boolean s = bean.isStatus();
		return userDAO.updateUserStatus(userId, !s);
	}

	@Override
	public UserVO searchUserVOById(String userId) {
		UserVO vo = userDAO.queryUserVOById(userId);
		return vo;
	}
	
}
