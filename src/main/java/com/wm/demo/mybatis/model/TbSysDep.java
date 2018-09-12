package com.wm.demo.mybatis.model;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class TbSysDep {
	
	private String id;
	private String depName;
	
	private List<TbSysUserVO> userList;

}
