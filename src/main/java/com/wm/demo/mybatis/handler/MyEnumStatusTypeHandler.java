package com.wm.demo.mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.wm.demo.mybatis.model.UserStatus;

/**
 * 1、实现TypeHandler接口。或者继承BaseTypeHandler
 * @author lfy
 *
 */
public class MyEnumStatusTypeHandler implements TypeHandler<UserStatus> {

	/**
	 * 定义当前数据如何保存到数据库中
	 */
	@Override
	public void setParameter(PreparedStatement ps, int i, UserStatus parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("要保存的状态码：" + parameter.getCode());
		ps.setString(i, parameter.getCode().toString());
	}

	@Override
	public UserStatus getResult(ResultSet rs, String columnName) throws SQLException {
		int code = rs.getInt(columnName);
		System.out.println("从数据库中获取的状态码：" + code);
		UserStatus status = UserStatus.getEmpStatusByCode(code);
		return status;
	}

	@Override
	public UserStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
		int code = rs.getInt(columnIndex);
		System.out.println("从数据库中获取的状态码：" + code);
		UserStatus status = UserStatus.getEmpStatusByCode(code);
		return status;
	}

	@Override
	public UserStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
		int code = cs.getInt(columnIndex);
		System.out.println("从数据库中获取的状态码：" + code);
		UserStatus status = UserStatus.getEmpStatusByCode(code);
		return status;
	}

}
