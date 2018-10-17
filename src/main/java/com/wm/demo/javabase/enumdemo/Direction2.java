package com.wm.demo.javabase.enumdemo;

/*
 * 通过JDK5提供的枚举来做枚举类
 */
public enum Direction2 {
	FRONT("前"), BEHIND("后"), LEFT("左"), RIGHT("右");

	private String name;

	private Direction2(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	 @Override
	 public String toString() {
		 return "wm";
	 }
}
