package com.wm.demo.learn.base.fanxing;

public class Demo02InterImpl<T> implements Demo02Inter<T>{

	@Override
	public void show(T t) {
		System.out.println(t);
	}
	
	public static void main(String[] args) {
		Demo02Inter<String> inter = new Demo02InterImpl<>();
		inter.show("GG");
	}

}
