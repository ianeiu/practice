package com.wm.demo.writeexam;

import org.junit.Test;

public class OperatorJia {

	@Test
	public void testOperator() {
		byte b1 = 3, b2 = 4, b;
		// b=b1+b2;//编译失败,b1+b2为int相加
		b = 3 + 4;
		System.out.println(b);

		short s = 1;
		// s = s + 1; //编译失败,同理
		System.out.println(s);

		short s2 = 1;
		// += 扩展的赋值运算符其实隐含了一个强制类型转换
		s2 += 1; // 等价于 s2 = (short)s2 + 1;
		System.out.println(s2);
	}

	@Test
	public void testOperator01() {
		// 加法
		System.out.println(3 + 4);

		// 正号
		System.out.println(+4);

		System.out.println('a');//4
		System.out.println('a' + 1); // 99

		// 字符串连接符
		System.out.println("hello" + 'a' + 1);//helloa1
		System.out.println('a' + 1 + "hello");//98hello
	}

}
