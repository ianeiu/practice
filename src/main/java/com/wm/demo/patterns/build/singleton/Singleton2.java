package com.wm.demo.patterns.build.singleton;

// 饿汉(不会出问题的单例模式)
public class Singleton2 {
	private static Singleton2 instance = new Singleton2();

	private Singleton2() {
	}

	public static Singleton2 getInstance() {
		return instance;
	}
}