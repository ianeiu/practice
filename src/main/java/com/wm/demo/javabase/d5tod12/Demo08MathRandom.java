package com.wm.demo.javabase.d5tod12;

import java.util.Random;
import java.util.Scanner;

public class Demo08MathRandom {
	public static void main(String[] args) {
		System.out.println(Math.E);//常数e 2.718281828459045
		System.out.println(Math.PI);//3.141592653589793
		System.out.println(Math.abs(-5));//绝对值
		System.out.println(Math.ceil(5.61d));//浮点型参数：向上取整   6.0 返回double
		System.out.println(Math.floor(5.61d));//浮点型参数：向下取整  5.0  返回double
		System.out.println(Math.max(5, 10));//取最大值
		System.out.println(Math.min(5, 10));//取最小值
		System.out.println(Math.pow(2, 3));//2的三次幂  返回double
		System.out.println(Math.random());//[0.0,1.0)
		System.out.println(Math.round(5.6d));//浮点型参数：四舍五入 
		System.out.println(Math.sqrt(4));//正平方根
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入开始数：");
		int start = sc.nextInt();
		System.out.println("请输入结束数：");
		int end = sc.nextInt();
		for (int x = 0; x < 100; x++) {
			// 调用功能
			int num = getRandom(start, end);
			// 输出结果
			System.out.println(num);
		}
		sc.close();
		
		//---------------------------------------------------------------
		// Random r = new Random();
		Random r = new Random(1111);
		System.out.println(r);
		for (int x = 0; x < 10; x++) {
			// int num = r.nextInt();
			int num = r.nextInt(100) + 1;
			System.out.println(num);
		}
	}
	
	public static int getRandom(int start, int end) {
		int number = (int) (Math.random() * (end - start + 1)) + start;
		return number;
	}
}
