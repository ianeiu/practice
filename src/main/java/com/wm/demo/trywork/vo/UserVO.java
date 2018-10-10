package com.wm.demo.trywork.vo;

import java.util.List;

import lombok.Data;

@Data
public class UserVO {
	private String userId;
	private String userName;
	private String sex;
	private String sexDesc;
	private List<String> list;
	
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		UserVO vo = new UserVO();
		vo.userId = this.userId;
		vo.userName = this.userName;
		vo.sex = this.sex;
		vo.sexDesc = this.sexDesc;
		vo.list = this.list;
		return vo;
	}



	public UserVO(String userId, String userName, String sex) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.sex = sex;
	}



	public UserVO() {
		super();
	}
	
	
}
