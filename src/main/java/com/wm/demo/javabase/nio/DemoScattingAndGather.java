package com.wm.demo.javabase.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class DemoScattingAndGather {
	public static void main(String args[]) {
		gather();
	}

	public static void gather() {
		ByteBuffer header = ByteBuffer.allocate(10);
		ByteBuffer body = ByteBuffer.allocate(10);
		byte[] b1 = { '0', '1' };
		byte[] b2 = { '2', '3' };
		header.put(b1);
		body.put(b2);
		ByteBuffer[] buffs = { header, body };
		try (
			FileOutputStream os = new FileOutputStream("src/scattingAndGather.txt");
			FileChannel channel = os.getChannel();
		){
			channel.write(buffs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
