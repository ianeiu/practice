package com.wm.demo.trywork;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Demo01Date {
	public static void main(String[] args){
		String s = "05-08 06:34";
		String s2 = String.valueOf(LocalDateTime.now().getYear())+"-"+s;
		System.out.println(s2);
		//System.out.println(Calendar.YEAR);
	}
}
