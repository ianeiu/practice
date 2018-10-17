package com.wm.demo.javabase.socket.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * TCP协议接收数据：
 * A:创建接收端的Socket对象
 * B:监听客户端连接。返回一个对应的Socket对象
 * C:获取输入流，读取数据显示在控制台
 * D:释放资源
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		fun1();
		
		//fun2();
	}
	
	/**
	 * 读取客户端写入文件
	 * @throws IOException
	 */
	private static void fun2() throws IOException {
		// 创建服务器Socket对象
		ServerSocket ss = new ServerSocket(23456);

		// 监听客户端连接
		Socket s = ss.accept();

		// 封装通道内的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(
				s.getInputStream()));
		// 封装文本文件
		BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));

		String line = null;
		while ((line = br.readLine()) != null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}

		bw.close();
		// br.close();
		s.close();
		// ss.close();
	}

	/**
	 * 读取客户端输出控制台
	 * @throws IOException
	 */
	private static void fun1() throws IOException {
		// 创建接收端的Socket对象
		ServerSocket ss = new ServerSocket(12345);

		// 监听客户端连接。返回一个对应的Socket对象
		Socket s = ss.accept();// 侦听并接受到此套接字的连接。此方法在连接传入之前一直阻塞。

		// // 获取输入流，读取数据显示在控制台
		// InputStream is = s.getInputStream();
		// byte[] bys = new byte[1024];
		// int len = is.read(bys);// 阻塞式方法
		// String str = new String(bys, 0, len);
		// String ip = s.getInetAddress().getHostAddress();
		// System.out.println(ip + "--" + str);

		// //--获取输出流
		// OutputStream os = s.getOutputStream();
		// os.write("数据已收到".getBytes());

		// 包装通道内容的流------输出控制台
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		// // 封装通道内的数据------输出到文本
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(s.getInputStream()));
		// // 封装文本文件
		// BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
		// String line = null;
		// while ((line = br.readLine()) != null) {
		// bw.write(line);
		// bw.newLine();
		// bw.flush();
		// }

		// 释放资源
		s.close();
		// ss.close(); //这个不关闭
	}
}
