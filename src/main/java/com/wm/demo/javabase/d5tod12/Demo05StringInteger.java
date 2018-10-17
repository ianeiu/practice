package com.wm.demo.javabase.d5tod12;

import org.junit.Test;

public class Demo05StringInteger {
	
	@Test
	public void testStringBiJiao() {
		String s1="hello";
		String s2="world";
		String s3="helloworld";
		System.out.println(s1+s2==s3);//false
		System.out.println("helloworld"==s3);//true
	}
	
	@Test
	public void testIntegerBijiao() {
		Integer i1 = 127;
		Integer i2 = 127;
		Integer i3 = 128;
		Integer i4 = 128;
		System.out.println(i1==i2);//true
		System.out.println(i1==127);//true
		System.out.println(i1==126+1);//true
		System.out.println(i3==i4);//false
		System.out.println(i3==127+1);//true
		System.out.println(i3==129-1);//true
	}
}
