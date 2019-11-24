package com.wm.mybatis.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.experimental.Accessors;

@Alias("user")
@Data
@Accessors(chain=true)
public class TbSysUser implements Serializable {
	
	private static final long serialVersionUID = 2738094983146195753L;
	
	private String userId;
	private String userName;
	private String passwork;
	private Integer userSex;
	private Date createTime;
	//private boolean status;
	private String depId;
	//状态 Demo08
	private UserStatus status=UserStatus.LOGOUT;


	public TbSysUser() {
		super();
	}
	
	public TbSysUser(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	
	
}
