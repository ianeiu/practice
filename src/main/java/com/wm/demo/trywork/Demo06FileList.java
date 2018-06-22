package com.wm.demo.trywork;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Demo06FileList {
	public static void main(String[] args) {
		File[] fileArray = new File("E:\\testPush").listFiles();

		List<String> list = new ArrayList<>();
		
		for (File file : fileArray) {
			File[] fileDateArray = file.listFiles();
			for (File fileDate : fileDateArray) {
				File[] itemFiles = fileDate.listFiles();
				for (File itemFile : itemFiles) {
					if (itemFile.getName().endsWith(".txt")) {	// 判断是否以.txt结尾
						list.add(itemFile.getAbsolutePath());
					}
				}
			}
		}
		
		System.out.println(list);
	}
	
}
