package com.wm.demo.writeexam;

import java.lang.reflect.Field;

public class SwapIntegerValue {
	
	
	public static void main(String[] args) {
		Integer i1 = 1;
		Integer i2 = 2;
		System.out.printf("i1 = %s,i2 = %s \n",i1,i2);
		swap(i1,i2);
		System.out.printf("i1 = %s,i2 = %s",i1,i2);
	}

	private static void swap(Integer i1, Integer i2) {
		//错误
		/*
		Integer temp = i1;
		i1 = i2;
		i2 = temp;
		
		int temp = i1;
		i1 = new Integer(i2);
		i2 = new Integer(temp);
		*/
		
		int temp = i1;
		try {
			Field value = Integer.class.getDeclaredField("value");
			value.setAccessible(true);
			value.set(i1, i2);
			
			// 这样结果：i1 = 2,i2 = 2 
			// 在value.set的时候将Integer的缓存值改变了，因为value.set(Object v1, Object v2)两个参数都是对象类型，
			// 所以temp会进行自动装箱操作，会调用valueOf方法，这样会获取到错误的缓存值
			// 如果 i1 不在 -127~128 范围，就交换正常
			//value.set(i2,temp);
			
			value.set(i2,new Integer(temp));
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	
}
