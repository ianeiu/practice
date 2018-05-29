package com.wm.demo.learn.java5.foreach;

import java.util.ArrayList;
import java.util.List;

public class ForEachDemo {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("");
		list.add("123");
		list.add("wm");
		list.add("xix");
		list.add("heh");
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}
