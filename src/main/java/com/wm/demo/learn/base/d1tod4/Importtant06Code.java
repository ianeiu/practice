package com.wm.demo.learn.base.d1tod4;

public class Importtant06Code {
	static { System.out.println("Importtant06Code静态代码块");}
	
	public static void main(String[] args) {
		System.out.println("main");
		User user = new User();
		User user2 = new User();
	}
}

class User{
	static { System.out.println("User静态代码块");}
	{System.out.println("User局部代码块");}
	public User() {System.out.println("User构造代码块");}
	
}
