package com.wm.demo.javabase.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 	不同的系统针对不同的换行符号识别是不一样的
 * 		windows:\r\n
 * 		linux:\n
 * 		Mac:\r
 * 
 * 字节输出流操作步骤：
 * 	A:创建字节输出流对象
 * 	B:调用write()方法
 *	C:释放资源
 *
 * @author WM
 *
 */
public class Demo02FileOutputStream {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("fos.txt",false);//false非追加写入

		fos.write("hello,IO".getBytes());
		fos.write("\r\n".getBytes());
		byte[] bys={97,98,99,100,101};//a,b,c,d,e
		fos.write(bys,1,3);//b,c,d

		fos.close();
	}
}
