package com.wm.demo.trywork;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Demo03StringFun {
	
	@Test
	public void testStringToint(){
		String s = "111  ";
		int i  = Integer.parseInt(s);
		System.out.println(i);//java.lang.NumberFormatException: For input string: "111  "
	}
	
	@Test
	public void testEndWith(){
		String s  =  "213123";
		System.out.println(s.endsWith(""));
		System.out.println(s.endsWith(" "));
		System.out.println(s.endsWith("22"));
	}
	
	@Test
	public void testContains(){
		String str = "hello world";
		System.out.println(str.contains("hello"));//true
		System.out.println(str.contains("holl"));//false
	}
	
	/**
	 * @Description:  ==
	 * @author: wm
	 * @date: 2018年8月24日 下午2:09:13
	 * @version: 1.0
	 */
	@Test
	public void testDD(){
		String str = "helo";
		String str2 = "heloo";
		String str3 = str2.substring(0, str2.length()-1);
		
		System.out.println(str3); //helo
		System.out.println(str == str3); //false
	}
	
	@Test
	public void testJoin(){
		List<String> list = Arrays.asList("1","2","3");
		List<String> list2 = Arrays.asList();
		System.out.println(String.join(";", list));
		System.out.println(String.join(";", list2));
	}
}
