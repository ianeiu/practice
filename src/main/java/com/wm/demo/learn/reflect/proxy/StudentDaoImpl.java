package com.wm.demo.learn.reflect.proxy;

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
