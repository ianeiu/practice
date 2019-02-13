package com.wm.demo.javabase.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class TCPDemoClient {
	public static void main(String[] args) {
		client();
	}

	public static void client() {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		SocketChannel socketChannel = null;
		try {
			//打开
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("10.10.2.158", 8080));
			
			if (socketChannel.finishConnect()) {
				int i = 0;
				while (true) {
					TimeUnit.SECONDS.sleep(1);
					String info = "I'm " + i++ + "-th information from client";
					buffer.clear();
					buffer.put(info.getBytes());
					buffer.flip();
					while (buffer.hasRemaining()) {
						System.out.println(buffer);
						//写入通道
						socketChannel.write(buffer);
					}
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socketChannel != null) {
					socketChannel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
