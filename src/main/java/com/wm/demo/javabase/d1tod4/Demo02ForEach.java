package com.wm.demo.javabase.d1tod4;

import java.util.ArrayList;
import java.util.List;

public class Demo02ForEach {
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
