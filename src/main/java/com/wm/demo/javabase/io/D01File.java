package com.wm.demo.javabase.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class D01File {
	public static void main(String[] args) throws IOException {
		// 方式一
		File file = new File("F:\\EclipseBulider\\util\\src\\main\\java\\com\\wm\\demo\\learn\\base\\Demo07正则表达式的规则.txt");
		// //方式二
		// File file2 = new File("F:\\EclipseBulider\\util\\src\\main\\java\\com\\wm\\demo\\learn\\base","ZDemo07正则表达式的规则.txt");
		// //方式三
		// File file3 = new File("F:\\EclipseBulider\\util\\src\\main\\java\\com\\wm\\demo\\learn\\base");
		// File file4 = new File(file3,"Demo07正则表达式的规则.txt");
		System.out.println("createNewFile:" + file.createNewFile());

		/*File file5 = new File("E:\\EclipseBulider\\FileTestDemo\\aaa");
		System.out.println("mkdir:" + file5.mkdir());
		File file6 = new File("E:\\EclipseBulider\\FileTestDemo\\ddd\\bbb\\ccc");
		System.out.println("mkdirs:" + file6.mkdirs());
		System.out.println("------------------------");

		// System.out.println("deleteFile:"+file.delete());
		System.out.println("deleteFile5:" + file5.delete());
		System.out.println("deleteFile6:" + file6.delete());// 只删除ccc
		System.out.println("------------------------");*/

		File file7 = new File("F:\\\\EclipseBulider\\\\util\\\\src\\\\main\\\\java\\\\com\\\\wm\\\\demo\\\\learn\\\\base\\\\Demo07正则表达式的规则1.txt");
		// System.out.println("renameTo:"+file.renameTo(file7));
		System.out.println("--------------------------");

		// 判断功能
		System.out.println("isDirectory:" + file.isDirectory());// false
		System.out.println("isFile:" + file.isFile());// true
		System.out.println("exists:" + file.exists());// true
		System.out.println("canRead:" + file.canRead());// true
		System.out.println("canWrite:" + file.canWrite());// true
		System.out.println("isHidden:" + file.isHidden());// false
		System.out.println("--------------------------");

		// 获取功能
		System.out.println("getAbsolutePath:" + file.getAbsolutePath());
		System.out.println("getPath:" + file.getPath());
		System.out.println("getName:" + file.getName());
		System.out.println("length:" + file.length());
		System.out.println("lastModified:" + file.lastModified());

		Date date = new Date(file.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(date);
		System.out.println("lastModified:" + s);
		System.out.println("--------------------------");
		
		File file8 = new File("f:\\");
		
		String[] name = file8.list();
		for (String n : name) {
			System.out.print(n+" ");
		}
		System.out.println();
		System.out.println("--------------------------");
		
		File[] fileArray = file8.listFiles();
		for(File file9:fileArray){
			System.out.println("是否是目录："+file9.isDirectory()+"\t\t大小："+file9.length()+"\t\t名："+file9.getName());
		}
		System.out.println("--------------------------");
		

		/**等于**/
		for(File file9 : fileArray){
			if(file9.isFile()){
				if(file9.getName().endsWith(".jpg")){
					System.out.println(file9.getName()+"\t大小："+(file9.length())/1024+"kb");
				}
			}
		}
		
		String[] fileStr = file8.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir, name).isFile() && name.endsWith(".jpg");
			}
		});
		for(String s3:fileStr){
			System.out.println(s3);
		}
	}
}
