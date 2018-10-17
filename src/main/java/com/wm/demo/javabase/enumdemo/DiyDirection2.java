package com.wm.demo.javabase.enumdemo;

public class DiyDirection2 {
	// 创建几个实例
	public static final DiyDirection2 FRONT = new DiyDirection2("前");
	public static final DiyDirection2 BEHIND = new DiyDirection2("后");
	public static final DiyDirection2 LEFT = new DiyDirection2("左");
	public static final DiyDirection2 RIGHT = new DiyDirection2("右");

	// 构造私有，别人就不能无限的创建了
	// private Direction2() {
	// }

	// 加入成员变量,并去掉无参构造
	private String name;

	private DiyDirection2(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}