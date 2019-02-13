package com.wm.demo.javabase.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UDPDemoServer {
	public static void main(String[] args) {
		reveive();
	}
	
	public static void reveive() {
		DatagramChannel channel = null;
		try {
			channel = DatagramChannel.open();
			channel.socket().bind(new InetSocketAddress(8888));
			ByteBuffer buf = ByteBuffer.allocate(1024);
			buf.clear();
			channel.receive(buf);
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
			System.out.println();
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
