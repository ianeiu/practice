package com.wm.demo.writeexam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArraysAsList {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("1","2","3");
		//list.add("4");// java.lang.UnsupportedOperationException
		//list.remove(0);// java.lang.UnsupportedOperationException
		//本质还是数组，长度不可变
	}
}
