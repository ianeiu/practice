package com.wm.demo.javabase.socket.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * UDP协议发送数据：
 * A:创建发送端DatagramSocket对象
 * B:创建数据，并把数据打包
 * C:调用DatagramSocket对象的发送方法发送数据包
 * D:释放资源
 */
public class SendDemo {
	public static void main(String[] args) throws IOException {
		// --创建发送端DatagramSocket对象--12
		DatagramSocket ds = new DatagramSocket();

		// --创建数据，并把数据打包--
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = br.readLine())!=null){
			if("exit".equals(line))
				break;
			byte[] bys = line.getBytes();
			DatagramPacket dg = new DatagramPacket(bys, bys.length, InetAddress.getByName("192.168.1.101"), 2233);
			
			//--调用DatagramSocket对象的发送方法发送数据包--
			ds.send(dg);	
		}
		
		//--释放资源--
		ds.close();
	}
}
