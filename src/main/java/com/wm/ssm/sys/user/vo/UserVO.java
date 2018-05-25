package com.wm.ssm.sys.user.vo;

import com.wm.ssm.sys.role.model.TbSysRole;

public class UserVO {
	
	private String userId;
	private String userName;
	
	private TbSysRole role;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public TbSysRole getRole() {
		return role;
	}

	public void setRole(TbSysRole role) {
		this.role = role;
	}

	
	
}
