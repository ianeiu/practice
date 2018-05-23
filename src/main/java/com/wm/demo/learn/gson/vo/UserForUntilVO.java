package com.wm.demo.learn.gson.vo;

import com.google.gson.annotations.Until;



/* 
 * @Until(float v)注解 版本控制
 * 当gson的setVersion(n) n<v 才解析
 */
public class UserForUntilVO {
	private String id;
	private String userName; 
	@Until(2)
	private String userSex;
	private String password;
	
	
	public UserForUntilVO() {
		super();
	}

	public UserForUntilVO(String id, String userName, String userSex, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.userSex = userSex;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", userName=" + userName + ", userSex="
				+ userSex + ", password=" + password + "]";
	}
	
	
}
