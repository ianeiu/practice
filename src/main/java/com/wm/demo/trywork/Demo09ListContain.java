package com.wm.demo.trywork;

import java.util.ArrayList;
import java.util.List;

public class Demo09ListContain {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("如果还有明天");
		list.add("你会怎样装扮你的脸");
		list.add("如果还有明天~~");
		
		String s1 = "如果还有明天~";
		String s2 = "如果还有明天~~";
		
		System.out.println(list.contains(s1));//false
		System.out.println(list.contains(s2));//true
	}
}
