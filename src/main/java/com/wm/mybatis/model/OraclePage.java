package com.wm.mybatis.model;

import java.util.List;

import lombok.Data;

/**
 * 封装分页查询数据
 *
 */
@Data
public class OraclePage<T> {
	
	private int start;
	private int end;
	private int count;
	private List<T> users;
	

}
