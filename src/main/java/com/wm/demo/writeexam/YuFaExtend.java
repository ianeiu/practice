package com.wm.demo.writeexam;

public class YuFaExtend {
	public static void main(String[] args) {
		
	}
}

class UserVO{
	private String userName;

	public UserVO(String userName) {
		super();
		this.userName = userName;
	}

	
}

/**
 * 父类没有无参构造，编译会报错
 * Implicit super constructor UserVO() is undefined for default constructor. Must define an explicit constructor
 */
/*
class Admin extends UserVO{
	private String power;
	
}
*/
