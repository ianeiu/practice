package com.wm.demo.javabase.enumdemo;

public abstract class DiyDirection3 {
	// 创建几个实例
	public static final DiyDirection3 FRONT = new DiyDirection3("前") {
		@Override
		public void show() {
			System.out.println("前");
		}

	};
	public static final DiyDirection3 BEHIND = new DiyDirection3("后") {
		@Override
		public void show() {
			System.out.println("后");
		}

	};
	public static final DiyDirection3 LEFT = new DiyDirection3("左") {
		@Override
		public void show() {
			System.out.println("左");
		}

	};
	public static final DiyDirection3 RIGHT = new DiyDirection3("右") {
		@Override
		public void show() {
			System.out.println("右");
		}

	};

	// 构造私有，别人就不能无限的创建了
	// private Direction2() {
	// }

	// 加入成员变量,并去掉无参构造
	private String name;

	private DiyDirection3(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// 加入抽象方法
	public abstract void show();
}
