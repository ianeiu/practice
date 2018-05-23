package com.wm.demo.learn.base.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Demo07OtherIO {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// DataStreamFun();
		// ByteArrayStreamFun();
		// PrintWriterCopyFun();
		// SystemFun();
		// RandomAccessFileFun();
		// SequenceInputStreamFun();
		 ObjectStreamFun();
	}

	/**
	 * 序列化流、反序列化流
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static void ObjectStreamFun() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("oos.txt"));
		Demo07PersonVO p = new Demo07PersonVO("林青霞", 27);
		oos.writeObject(p);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("oos.txt"));
		Object obj = ois.readObject();
		ois.close();
		System.out.println(obj);
	}

	/**
	 * 合并流
	 * @throws IOException
	 */
	private static void SequenceInputStreamFun() throws IOException {
		// TODO Auto-generated method stub
		//二合一
		SequenceInputStream sis = new SequenceInputStream(new FileInputStream("raf.txt"),
				new FileInputStream("test.txt"));
		
		//多合一
		Vector<InputStream> v = new Vector<InputStream>();
		InputStream s1 = new FileInputStream("ByteArrayStreamDemo.java");
		InputStream s2 = new FileInputStream("CopyFileDemo.java");
		InputStream s3 = new FileInputStream("DataStreamDemo.java");
		v.add(s1);
		v.add(s2);
		v.add(s3);
		Enumeration<InputStream> en = v.elements();
		SequenceInputStream sis2 = new SequenceInputStream(en);
		
		//写
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Copy.txt"));
		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = sis.read(bys)) != -1) {
			bos.write(bys, 0, len);
		}
		bos.close();
		sis.close();
		
	}

	/**
	 * 随机访问流
	 * @throws IOException
	 */
	private static void RandomAccessFileFun() throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile raf1 = new RandomAccessFile("raf.txt", "rw");
		raf1.writeInt(100);
		raf1.writeChar('a');
		raf1.writeUTF("中国");
		// raf.close();

		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");

		int i = raf.readInt();
		System.out.println(i);
		// 该文件指针可以通过 getFilePointer方法读取，并通过 seek 方法设置。
		System.out.println("当前文件的指针位置是：" + raf.getFilePointer());

		char ch = raf.readChar();
		System.out.println(ch);
		System.out.println("当前文件的指针位置是：" + raf.getFilePointer());

		String s = raf.readUTF();
		System.out.println(s);
		System.out.println("当前文件的指针位置是：" + raf.getFilePointer());

		// 我不想重头开始了，我就要读取a，怎么办呢?
		raf.seek(4);
		ch = raf.readChar();
		System.out.println(ch);
	}

	/**
	 * 标准输入输出流
	 * @throws IOException
	 */
	private static void SystemFun() throws IOException {
		// TODO Auto-generated method stub
		PrintStream ps = System.out;
		ps.println("helloworld");
		ps.println();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("hello");
		bw.newLine();
		bw.write("world");
		bw.newLine();
		bw.write("java");
		bw.newLine();
		bw.flush();
		bw.close();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入一个字符串：");
		String line = br.readLine();
		System.out.println("你输入的字符串是：" + line);
	}

	/**
	 * 打印流-复制文本文件
	 * @throws IOException
	 */
	private static void PrintWriterCopyFun() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));//源
		PrintWriter pw = new PrintWriter(new FileWriter("Copy.txt"), true);//目的
		String line = null;
		while ((line = br.readLine()) != null) {
			pw.println(line);
		}
		pw.close();
		br.close();

	}

	/**
	 * 内存操作流
	 * @throws IOException
	 */
	private static void ByteArrayStreamFun() throws IOException {
		// TODO Auto-generated method stub
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		for (int x = 0; x < 10; x++) {
			baos.write(("hello" + x).getBytes());
		}

		byte[] bys = baos.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(bys);
		int by = 0;
		while ((by = bais.read()) != -1) {
			System.out.print((char) by);
		}
		// 不需要close
	}

	/**
	 * 数据输入输出流
	 * @throws IOException
	 */
	private static void DataStreamFun() throws IOException {
		// TODO Auto-generated method stub
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("test.txt"));
		dos.writeInt(50);
		dos.writeByte(66);
		dos.writeUTF("ai中國");
		dos.writeBoolean(false);
		dos.close();

		DataInputStream dis = new DataInputStream(new FileInputStream("test.txt"));
		int i = dis.readInt();
		byte b = dis.readByte();
		String s = dis.readUTF();
		Boolean bool = dis.readBoolean();
		dis.close();
		System.out.println(i + "\t" + b + "\t" + s + "\t" + bool);
	}
}
