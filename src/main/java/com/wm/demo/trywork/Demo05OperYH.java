package com.wm.demo.trywork;

/**
 * @Description: Demo15OperYH 异或
 * @author: wm
 * @date: 2018年8月23日 下午2:35:55
 * @version: 1.0
 */
public class Demo05OperYH {
	
	public static void main(String[] args) {
		boolean tflag = true;
		boolean fflag = false;
		
		System.out.println(tflag ^ tflag);  // true ^ true -> false
		System.out.println(tflag ^ fflag);  // true ^ false -> true
		System.out.println(fflag ^ fflag);  // false ^ false -> false
	}
}
