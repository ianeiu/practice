package com.wm.demo.patterns.strut.proxy.dynamic;

/*
 * 用户操作接口
 */
public interface UserDao {
	public abstract void add();

	public abstract void delete();

	public abstract void update();

	public abstract void find();
}