package com.wm.demo.trywork;

import java.util.ArrayList;
import java.util.List;

public class Demo06ListParam {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("qqq");
		System.out.println(list);
		changeList(list);
		System.out.println(list);
	}

	private static void changeList(List<String> list) {
		list.add("aaaa");
	}
}
