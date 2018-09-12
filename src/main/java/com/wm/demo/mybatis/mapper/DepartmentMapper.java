package com.wm.demo.mybatis.mapper;

import com.wm.demo.mybatis.model.TbSysDep;

public interface DepartmentMapper {

	TbSysDep getDepById(String id);

	TbSysDep getDepByIdPlus(String id);

	TbSysDep getDepByIdStep(String id);

}
