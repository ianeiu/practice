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
}
