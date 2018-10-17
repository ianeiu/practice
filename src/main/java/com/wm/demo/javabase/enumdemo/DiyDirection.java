package com.wm.demo.javabase.enumdemo;

public class DiyDirection {
	// 创建几个实例
	public static final DiyDirection FRONT = new DiyDirection();
	public static final DiyDirection BEHIND = new DiyDirection();
	public static final DiyDirection LEFT = new DiyDirection();
	public static final DiyDirection RIGHT = new DiyDirection();

	// 构造私有，别人就不能无限的创建了
	private DiyDirection() {
	}
}