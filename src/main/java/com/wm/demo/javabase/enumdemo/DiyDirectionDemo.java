package com.wm.demo.javabase.enumdemo;

public class DiyDirectionDemo {
	public static void main(String[] args) {
		DiyDirection d = DiyDirection.FRONT;
		System.out.println(d); // cn.itcast_01.Direction@175078b
		System.out.println("------------------------------------");
		DiyDirection2 d2 = DiyDirection2.FRONT;
		System.out.println(d2);// cn.itcast_01.Direction2@11563ff
		System.out.println(d2.getName());
		d2 = DiyDirection2.RIGHT;
		System.out.println(d2);
		System.out.println(d2.getName());
		System.out.println("------------------------------------");
		DiyDirection3 d3 = DiyDirection3.FRONT;
		System.out.println(d3);
		System.out.println(d3.getName());
		d3.show();

		d3 = DiyDirection3.LEFT;
		System.out.println(d3);
		System.out.println(d3.getName());
		d3.show();
	}
}
