package com.wm.demo.javabase.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer有资源释放的问题：被MappedByteBuffer打开的文件只有在垃圾收集时才会被关闭，而这个点是不确定的
 */
public class DemoMappedByteBuffer {
	public static void main(String[] args) {
		method3();
		method4();
		/*
		小文件效果不明显，有时ByteBuffer更快
		Read time: 1ms
		Read time: 1ms
		
		writeBig 追加10W后效果
		Read time: 1ms
		Read time: 5ms
		
		writeBig 追加100W后效果
		Read time: 2ms
		Read time: 43ms
		*/
	}
	
	/**
	 * MappedByteBuffer
	 */
	public static void method3() {
		RandomAccessFile aFile = null;
		FileChannel fc = null;
		try {
			aFile = new RandomAccessFile("src/1.ppt", "rw");
			writeBig(aFile);
			fc = aFile.getChannel();
			long timeBegin = System.currentTimeMillis();
			MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, aFile.length());
			// System.out.println((char)mbb.get((int)(aFile.length()/2-1)));
			// System.out.println((char)mbb.get((int)(aFile.length()/2)));
			// System.out.println((char)mbb.get((int)(aFile.length()/2)+1));
			long timeEnd = System.currentTimeMillis();
			System.out.println("Read time: " + (timeEnd - timeBegin) + "ms");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (aFile != null) {
					aFile.close();
				}
				if (fc != null) {
					fc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ByteBuffer
	 */
	public static void method4() {
		RandomAccessFile aFile = null;
		FileChannel fc = null;
		try {
			aFile = new RandomAccessFile("src/1.ppt", "rw");
			writeBig(aFile);
			fc = aFile.getChannel();
			long timeBegin = System.currentTimeMillis();
			ByteBuffer buff = ByteBuffer.allocate((int) aFile.length());
			buff.clear();
			fc.read(buff);
			// System.out.println((char)buff.get((int)(aFile.length()/2-1)));
			// System.out.println((char)buff.get((int)(aFile.length()/2)));
			// System.out.println((char)buff.get((int)(aFile.length()/2)+1));
			long timeEnd = System.currentTimeMillis();
			System.out.println("Read time: " + (timeEnd - timeBegin) + "ms");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (aFile != null) {
					aFile.close();
				}
				if (fc != null) {
					fc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	
	private static void writeBig(RandomAccessFile aFile) throws IOException {
		for(int i=0;i<100000;i++){
			aFile.write("test test test test test test test test test test test test ".getBytes());
		}
	}

}
