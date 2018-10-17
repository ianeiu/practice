package com.wm.demo.javabase.fanxing;

/**
 * 泛型：在编译时检查类型安全，限制了变量的类型，消除强制类型转换问题
 * @author WM
 *
 */
public class Demo01Fun {
	
	public <T> void show(T t) {
		System.out.println(t);
	}
	
	public static void main(String[] args) {
		Demo01Fun fun = new Demo01Fun();
		fun.show("ttt");
		fun.show(111);
	}
}
