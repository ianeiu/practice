package com.wm.demo.learn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class RelflectDemo {
	public static void main(String[] args) throws Exception {
		Person p = new Person();
		Class c1 = p.getClass();
		Class c2 = Person.class;
		Class c3 = Class.forName("com.wm.demo.learn.reflect.Person");

		// Constructor[] cons = c3.getDeclaredConstructors();
		// for (Constructor con : cons) {
		// System.out.println(con);
		// }

		//构造方法
		Constructor con = c3.getConstructor();
		Object obj = con.newInstance();
		System.out.println(obj);	// Person [name=null, age=0, address=null]
		
		Constructor con2 = c3.getDeclaredConstructor(String.class,int.class);
		Object obj2 = con2.newInstance("dad",15);
		System.out.println(obj2);//Person [name=dad, age=15, address=null]
		
		Constructor con3 = c3.getDeclaredConstructor(String.class);
		con3.setAccessible(true);//取消java语言访问检查
		Object obj3 = con3.newInstance("asd");
		System.out.println(obj3);//Person [name=asd, age=0, address=null]
		
		//成员变量
		Field af = c3.getField("address");
		Field agf = c3.getDeclaredField("age");
		Field nf = c3.getDeclaredField("name");
		nf.setAccessible(true);
		af.set(obj3, "asda12");
		agf.set(obj3, 15);
		nf.set(obj3, "sadasda");
		System.out.println(obj3);//Person [name=sadasda, age=15, address=asda12]
		
		//成员方法
		Method m1 = c3.getMethod("show");
		m1.invoke(obj3, null);
		Method m2 = c3.getMethod("method", String.class);
		m2.invoke(obj3, "balaba");
		
		
		//往  ArrayList<Integer> list 增加元素 “hello”
		ArrayList<Integer> list = new ArrayList<>();
		Class cl =	list.getClass();
		Method m = cl.getMethod("add", Object.class);
		m.invoke(list, "hello");
		System.out.println(list);
	}
}
