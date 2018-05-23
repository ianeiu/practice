package com.wm.demo.learn.base.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;

public class Demo05RWBase {
	public static void main(String[] args) throws IOException {
		/**
		 * InputStreamReader(InputStream is):用默认的编码读取数据 InputStreamReader(InputStream
		 * is,String charsetName):用指定的编码读取数据 InputStreamReader的方法： int read():一次读取一个字符
		 * 
		 * int read(char[] chs):一次读取一个字符数组
		 */
		InputStreamReader isr = new InputStreamReader(new FileInputStream("pom.xml"), "UTF-8");

		char[] chs = new char[1024];
		int len = 0;
		while ((len = isr.read(chs)) != -1) {
			System.out.print(new String(chs, 0, len));
		}

		isr.close();

		/**
		 * 
		 * OutputStreamWriter(OutputStream out):根据默认编码把字节流的数据转换为字符流
		 * OutputStreamWriter(OutputStream out,String charsetName):根据指定编码把字节流数据转换为字符流
		 * 
		 * OutputStreamWriter的方法： public void write(int c):写一个字符 public void
		 * write(char[] cbuf):写一个字符数组 public void write(char[] cbuf,int off,int len):写一个字符数组的一部分 public void write(String str):写一个字符串 public void
		 * write(String str,int off,int len):写一个字符串的一部分
		 */
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("osw.txt"), "UTF-8"); // 指定UTF-8
		osw.write("中国");
		osw.flush();
		
		osw.close();
		
		
		/**
		 * 
		 * BufferedReader 
		 * 		|--LineNumberReader 
		 * 			public int getLineNumber()获得当前行号。
		 * 			public void setLineNumber(int lineNumber)
		 */
		LineNumberReader lnr = new LineNumberReader(new FileReader("pom.xml"));
		lnr.setLineNumber(10);// 从10开始
		String line = null;
		while ((line = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber() + ":" + line);
		}
		lnr.close();
	}
}
