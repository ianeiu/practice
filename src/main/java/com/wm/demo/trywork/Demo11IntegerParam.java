package com.wm.demo.trywork;

public class Demo11IntegerParam {
	public static void main(String[] args) {
		
		//Integer i = 6;//6
		Integer i = new Integer(6);//6
		change(i);
		System.out.println(i);
	}

	private static void change(Integer i) {
		i++;
	}
	
	
	
}
