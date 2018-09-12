package com.wm.demo.mybatis.model;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class TbSysUserVO {
	private String userId;
	private String userName;
	private String password;
	private Integer userSex;
	private Date createTime;
	private boolean status;
	private TbSysDep dep;
}
