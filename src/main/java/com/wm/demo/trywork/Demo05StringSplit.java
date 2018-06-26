package com.wm.demo.trywork;

import org.junit.Test;

public class Demo05StringSplit {
	
	@Test
	public void testS2(){
		String str = "NEW2018512593138767_中文xxxxxx2.txt" ;
		//String str = "" ;
		System.out.println(str.split("_")[0]);
	}
	
	@Test
	public void testS1() {
		String str = "人名命名的文件夹~m~日期命名的文件夹~m~~密文文件.txt";
		String[] results = str.split("[~][m][~]");
		
		for (int i=0;i<results.length;i++) {
			System.out.println(results[i]);
		}
	}
}
