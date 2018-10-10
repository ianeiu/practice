package com.wm.demo.writeexam;

public class CodeLoadOrder {
	
	static { System.out.println("CodeLoadOrder静态代码块");}
	
	public static void main(String[] args) {
		System.out.println("main");
		User user = new User();
		User user2 = new User();
		
		/*Importtant06Code静态代码块
		main
		User静态代码块
		User局部代码块
		User构造代码块
		User局部代码块
		User构造代码块*/

	}
}

class User{
	static { System.out.println("User静态代码块");}
	{System.out.println("User局部代码块");}
	public User() {System.out.println("User构造代码块");}
	
}
