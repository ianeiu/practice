package com.wm.demo.writeexam;

public class IntegerDD {
	

	public static void main(String[] args) {

		Integer a = 1000,b=1000;
		Integer c = 100,d=100;   
		Integer e = new Integer(100);
		Integer f = new Integer(100);
		int g = 1000;
		Integer h = new Integer(1000);
		
		
		//1、进行自动装箱操作；2、Integer中把-128-127 缓存了下来
		//此块可看Integer源码valueOf(int i)方法
		// public static Integer valueOf(int i) {
		// 	if (i >= IntegerCache.low && i <= IntegerCache.high)
		// 	return IntegerCache.cache[i + (-IntegerCache.low)];
		// 	return new Integer(i);
		// }
	    System.out.println(a==b);//false  
		System.out.println(c==d);//true
		
		//这里并不是用的缓存，而是new创建的对象存放在堆内存中，俩个变量指向不同引用，所以结果是false
		System.out.println(e==f);//false
		//当int和Integer进行==比较的时候，Java会把Integer进行自动拆箱为int类型的值
		System.out.println(g==h);//true
		
		//进行自动装箱操作
		System.out.println(c==e);//false
		System.out.println(a==h);//false
    }
}
