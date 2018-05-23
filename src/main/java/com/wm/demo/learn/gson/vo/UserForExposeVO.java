package com.wm.demo.learn.gson.vo;

import com.google.gson.annotations.Expose;

/* 
 * 
 * 可以排除不需要序列化的字段,需要配合GsonBuilder使用  
 * Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
 * 不添加@Expose注解的字段将不会解析: 分为以下几种情况: 
 * 1:不添加@Expose注解等同于@Expose(deserialize = false,serialize = false) 不做任何解析 
 * 2:@Expose(deserialize = true,serialize = false) 只解析用用，也就是反序列化可以，序列化不可以
 * 3:@Expose(deserialize = false,serialize = true)序列化可以，反序列化不行 
 * 4:@Expose(deserialize = true,serialize = true) 既可以序列化，也可以反序列化
 */
public class UserForExposeVO {
	private String id;
	@Expose(deserialize = true,serialize = false) //只解析用用，也就是反序列化可以，序列化不可以
	private String userName;
	@Expose(deserialize = false,serialize = true) //序列化可以，反序列化不行 
	private String userSex;
	@Expose //等同于 @Expose(deserialize = true,serialize = true) 
	private String password;
	
	
	public UserForExposeVO() {
		super();
	}

	public UserForExposeVO(String id, String userName, String userSex, String password) {
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
