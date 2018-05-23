package com.wm.demo.trywork;

public class Demo02StringToInt {
	public static void main(String[] args) {
		String s = "111  ";
		int i  = Integer.parseInt(s);
		
		System.out.println(i);//java.lang.NumberFormatException: For input string: "111  "
	}	
}
