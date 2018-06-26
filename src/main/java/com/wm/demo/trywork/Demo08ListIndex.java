package com.wm.demo.trywork;

import java.util.ArrayList;
import java.util.List;

public class Demo08ListIndex {
	public static void main(String[] args) {
		
		String s = "如果";
		String s2 = "吾未眠";
		String s3 = "如果还要明天";
		String sforlist = "如果还要明天如果";
		
		List<String> list = new ArrayList<>();
		list.add(sforlist);
		list.add("你会怎样装扮你的脸");
		list.add("XXXXXXXXXXXXXXX如果");
		
		System.out.println(list.toString());
		System.out.println(list.toString().indexOf(s));//1
		System.out.println(list.toString().indexOf(s2));//-1
		System.out.println("-------------------------");
		System.out.println(s.indexOf(sforlist));//-1
		System.out.println(sforlist.indexOf(s));//0
		System.out.println(sforlist.indexOf(s3));//0
		System.out.println(sforlist.indexOf(s2));//-1
	}
}
