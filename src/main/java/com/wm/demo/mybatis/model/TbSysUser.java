package com.wm.demo.mybatis.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("user")
@Data
public class TbSysUser {
	private String userId;
	private String userName;
	private String passwork;
	private Integer userSex;
	private Date createTime;
	private boolean status;
	private String depId;
}
