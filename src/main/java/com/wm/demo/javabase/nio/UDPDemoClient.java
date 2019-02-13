package com.wm.demo.javabase.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UDPDemoClient {
	
	public static void main(String[] args) {
		send();
	}
	

	public static void send() {
		DatagramChannel channel = null;
		try {
			channel = DatagramChannel.open();
			String info = "I'm the Sender!";
			ByteBuffer buf = ByteBuffer.allocate(1024);
			buf.clear();
			buf.put(info.getBytes());
			buf.flip();
			int bytesSent = channel.send(buf, new InetSocketAddress("10.10.2.158", 8888));
			System.out.println(bytesSent);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (channel != null) {
					channel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
