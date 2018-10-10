package com.wm.demo.trywork;

import java.util.Arrays;
import java.util.List;

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
	
}
