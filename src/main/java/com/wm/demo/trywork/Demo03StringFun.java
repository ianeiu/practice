package com.wm.demo.trywork;

import org.junit.Test;

public class Demo03StringFun {
	
	@Test
	public void testEndWith(){
		String s  =  "213123";
		System.out.println(s.endsWith(""));
		System.out.println(s.endsWith(" "));
		System.out.println(s.endsWith("22"));
	}
}
