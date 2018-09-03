package com.wm.demo.trywork;

import org.apache.commons.lang.StringUtils;
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
	
	@Test
	public void testXG(){
		String str = "标签1/标签2";
		String[] results = str.split("/");
		
		for (int i=0;i<results.length;i++) {
			System.out.println(results[i]);
		}
	}
	
	@Test
	public void testUtilSplit(){
		String str = "Z;asdfads;1212";
		//String str = null;
		//String str = "";
		String[] strs = StringUtils.split(str, ";");
		for (String string : strs) {
			System.out.println(string);
		}
	}
}
