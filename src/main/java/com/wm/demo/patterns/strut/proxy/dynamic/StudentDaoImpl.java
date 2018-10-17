package com.wm.demo.patterns.strut.proxy.dynamic;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void login() {
		System.out.println("登录功能");
	}

	@Override
	public void regist() {
		System.out.println("注册功能");
	}

}
