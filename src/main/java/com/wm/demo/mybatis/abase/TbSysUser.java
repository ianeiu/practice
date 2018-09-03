package com.wm.demo.mybatis.abase;

import java.util.Date;

import lombok.Data;

@Data
public class TbSysUser {
	private String userId;
	private String userName;
	private String password;
	private String userSex;
	private Date createTime;
	private boolean status;
	private String depId;
}
