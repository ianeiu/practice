package com.wm.demo.trywork;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class Demo03StringFun {

	@Test
	public void testStringToint() {
		String s = "111  ";
		int i = Integer.parseInt(s);
		System.out.println(i);// java.lang.NumberFormatException: For input
								// string: "111 "
	}

	@Test
	public void testEndWith() {
		String s = "213123";
		System.out.println(s.endsWith(""));
		System.out.println(s.endsWith(" "));
		System.out.println(s.endsWith("22"));
	}

	@Test
	public void testContains() {
		String str = "hello world";
		System.out.println(str.contains("hello"));// true
		System.out.println(str.contains("holl"));// false
	}

	/**
	 * 一些基本类型的变量和对象的引用变量都是在函数的栈内存中分配，而堆内存中则存放new 出来的对象和数组。然而除此之外还有一块区域叫做常量池。
像我们通常想String s1 = "hello"; 这样申明的字符串对象，其值就是存储在常量池中。
当我们创建String s1 = "hello"这样一个对象之后，"hello"就存储到了常量池（也可叫做字符串池）中，当我们创建引用String s2  = "hello" 的时候，
Java底层会优先在常量池中查找是否存在"hello"，如果存在则让s2指向这个值，不会重新创建，如果常量池中没有则创建并添加的池中。这就是为什么答案是true 和false的原因。
	 * @Description: ==
	 * @author: wm
	 * @date: 2018年8月24日 下午2:09:13
	 * @version: 1.0
	 */
	@Test
	public void testStringDD() {
		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");
		
		//都存储在常量池中,指向同一常量
		System.out.println(s1==s2); // true
		//存储在常量池中,存储在堆内存中
		System.out.println(s1==s3); // false
		
		String s4 = "helloo";
		/**
		 * 会重新在常量池创建常量（String不可变属性）
		 */
		String s5 = s1+"o";
		//都存储在常量池中,指向不同常量
		System.out.println(s4 == s5); // false

		//hello
		String s6 = s4.substring(0, s4.length() - 1);
		//substring返回的也是new出来的String对象
		System.out.println(s1 == s6); // false
		System.out.println(s3 == s6); // false
	}

	@Test
	public void testJoin() {
		List<String> list = Arrays.asList("1", "2", "3");
		List<String> list2 = Arrays.asList();
		System.out.println(String.join(";", list));
		System.out.println(String.join(";", list2));
	}

	@Test
	public void testStringFor() {
		// String labelIds = "xxx;aaaa;sss";
		String labelIds = "";
		String[] labelIdList = labelIds.split(";");
		for (String string : labelIdList) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testUtilReplace(){
		String str = "xixi**fff";
		System.out.println(StringUtils.replace(str, "*", "%"));
	}
}
