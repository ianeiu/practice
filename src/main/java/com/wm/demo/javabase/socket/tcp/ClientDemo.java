package com.wm.demo.javabase.socket.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/*
 * TCP协议发送数据：
 * A:创建发送端的Socket对象
 * 		这一步如果成功，就说明连接已经建立成功了。
 * B:获取输出流，写数据
 * C:释放资源
 */
public class ClientDemo {
	public static void main(String[] args) throws IOException {
		// 创建发送端的Socket对象
		Socket s = new Socket("192.168.1.101", 12345);

		// // 获取输出流，写数据
		// OutputStream os = s.getOutputStream();
		// os.write("dasdasd".getBytes());

		// //--获取输入流
		// InputStream is = s.getInputStream();
		// byte[] bys = new byte[1024];
		// int len = is.read(bys);
		// String fangKui = new String(bys, 0, len);
		// System.out.println(fangKui);
		
		// 键盘录入数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 把通道内的流给包装一下
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		String line = null;
		while((line = br.readLine())!=null){
			if("exit".equals(line))
				break;
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		// 释放资源
		s.close();
	}
}
