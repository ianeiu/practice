package com.wm.demo.learn.base.io;

import java.io.Serializable;
/**
 * Serializable 标记接口
 * @author WM
 *
 */
public class Demo07PersonVO implements Serializable{
	/**
	 * 不设置的话，下次VO改变再反序列化会报错
	 */
	private static final long serialVersionUID = 11087053484502888L;
	
	private String name;
	//private int age;
	private transient int age;//transient使变量不被序列化
	
	
	public Demo07PersonVO() {
		super();
	}

	public Demo07PersonVO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
