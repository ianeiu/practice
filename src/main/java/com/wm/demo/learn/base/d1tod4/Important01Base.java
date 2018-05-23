package com.wm.demo.learn.base.d1tod4;

import org.junit.Test;

public class Important01Base {

	@Test
	public void testOperator() {
		byte b1 = 3, b2 = 4, b;
		// b=b1+b2;//编译失败,b1+b2为int相加
		b = 3 + 4;
		System.out.println(b);
	}

	@Test
	public void testOperator01() {
		// 加法
		System.out.println(3 + 4);

		// 正号
		System.out.println(+4);

		System.out.println('a');
		System.out.println('a' + 1); // 这里是加法

		// 字符串连接符
		System.out.println("hello" + 'a' + 1);
		System.out.println('a' + 1 + "hello");
	}

	/*
	 * 面试题： short s=1;s = s+1;
	 * 
	 * short s=1;s+=1; 上面两个代码有没有问题，如果有，那里有问题。
	 * 
	 * 为什么第二个木有问题呢? 扩展的赋值运算符其实隐含了一个强制类型转换。
	 * 
	 * s += 1; 不是等价于 s = s + 1; 而是等价于 s = (s的数据类型)(s + 1);
	 */
	@Test
	public void testOperator03() {
		// short s = 1;
		// s = s + 1;
		// System.out.println(s);

		short s = 1;
		s += 1; // 好像是 s = s + 1;
		System.out.println(s);
	}
}
