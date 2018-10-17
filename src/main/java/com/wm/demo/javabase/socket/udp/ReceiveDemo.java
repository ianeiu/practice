package com.wm.demo.javabase.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * UDP协议接收数据：
 * A:创建接收端DatagramSocket对象
 * B:创建一个数据包(接收容器)
 * C:调用Socket对象的接收方法接收数据
 * D:解析数据包，并显示在控制台
 * E:释放资源
 */
public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
		// ---创建接收端DatagramSocket对象---
		DatagramSocket ds = new DatagramSocket(2233);
		while (true) {
			// ---创建一个数据包(接收容器)---
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);

			// ---调用DatagramSocket对象的接收方法接收数据
			ds.receive(dp);

			// ---解析数据包，并显示在控制台---
			// dp.getAddress()返回InetAddress对象,调用getHostAddress()方法获取ip地址
			String address = dp.getAddress().getHostAddress();
			// dp.getData()返回字节数组
			String s = new String(dp.getData(), 0, dp.getLength());
			System.out.println(address + "--" + s);
		}
		
		// ---释放资源---
		//ds.close();//接收端应该一直开着等待接收数据，是不需要关闭
	}
}
