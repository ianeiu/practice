package com.wm.mybatis.mapper;

import com.wm.mybatis.model.TbSysDep;

public interface DepartmentMapper {

	TbSysDep getDepById(String id);

	TbSysDep getDepByIdPlus(String id);

	TbSysDep getDepByIdStep(String id);

}
