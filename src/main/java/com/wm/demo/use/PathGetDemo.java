package com.wm.demo.use;

public class PathGetDemo {
	public static void main(String[] args) {
		path1();//建议使用
		path2();
	}
	
	private static void path1(){
		String path1 = PathGetDemo.class.getResource("").getPath()+"test.xml";
		System.out.println(path1);
	}
	
	private static void path2(){
		String path2 = PathGetDemo.class.getResource("test.xml").getPath();
		System.out.println(path2);
	}
}
