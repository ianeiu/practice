package com.wm.demo.learn.base.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo03FourFunCopyFile {
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		//method1("F:\\CloudMusic\\Jam - 七月上.mp3","Jam - 七月上.mp3");//102218
		//method2("F:\\CloudMusic\\Jam - 七月上.mp3","Jam - 七月上.mp3");//120
		//method3("F:\\CloudMusic\\Jam - 七月上.mp3","Jam - 七月上.mp3");//300
		method4("F:\\CloudMusic\\Jam - 七月上.mp3","Jam - 七月上.mp3");//20
		long end = System.currentTimeMillis();
		System.out.println("耗时："+(end-start));
	}
	
	// 高效字节流一次读写一个字节数组：
	public static void method4(String srcString, String destString) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));

		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = bis.read(bys)) != -1) {
			bos.write(bys, 0, len);
		}

		bos.close();
		bis.close();
	}

	// 高效字节流一次读写一个字节：
	public static void method3(String srcString, String destString) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));

		int by = 0;
		while ((by = bis.read()) != -1) {
			bos.write(by);
		}

		bos.close();
		bis.close();
	}

	public static void method2(String srcString, String destString) throws IOException {
		FileInputStream fis = new FileInputStream(srcString);
		FileOutputStream fos = new FileOutputStream(destString);
		
		byte[] bys = new byte[1024];
		int len = 0;
		while((len = fis.read(bys))!= -1){
			fos.write(bys, 0, len);
		}
		
	}

	public static void method1(String srcString, String destString) throws IOException {
		FileInputStream fis = new FileInputStream(srcString);
		FileOutputStream fos = new FileOutputStream(destString);

		int by = 0;
		while((by=fis.read())!= -1){
			fos.write(by);
		}
		
		fis.close();
		fos.close();
	}
}
