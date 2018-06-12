package com.wm.demo.trywork;

public class Demo05StringSplit {
	public static void main(String[] args) {
		String str = "人名命名的文件夹~m~日期命名的文件夹~m~~密文文件.txt";
		String[] results = str.split("[~][m][~]");
		
		for (int i=0;i<results.length;i++) {
			System.out.println(results[i]);
		}
	}
}
