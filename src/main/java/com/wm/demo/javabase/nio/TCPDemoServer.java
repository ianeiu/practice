package com.wm.demo.javabase.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Description: ServerNIODemo TCP   NIO实现
 * @author: wm
 * @date: 2019年2月13日 下午2:23:38
 * @version: 1.0
 */
public class TCPDemoServer {
	private static final int BUF_SIZE = 1024;
	private static final int PORT = 8080;
	private static final int TIMEOUT = 3000;

	public static void main(String[] args) {
		selector();
	}

	public static void handleAccept(SelectionKey key) throws IOException {
		//返回的通道需要转型
		ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
		SocketChannel sc = ssChannel.accept();
		sc.configureBlocking(false);
		//向Selector注册Channel 时附加对象 ByteBuffer实体
		sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
	}

	public static void handleRead(SelectionKey key) throws IOException {
		//返回的通道需要转型
		SocketChannel sc = (SocketChannel) key.channel();
		ByteBuffer buf = (ByteBuffer) key.attachment();
		long bytesRead = sc.read(buf);
		while (bytesRead > 0) {
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
			System.out.println();
			buf.clear();
			bytesRead = sc.read(buf);
		}
		if (bytesRead == -1) {
			sc.close();
		}
	}

	public static void handleWrite(SelectionKey key) throws IOException {
		ByteBuffer buf = (ByteBuffer) key.attachment();
		buf.flip();
		//返回的通道需要转型
		SocketChannel sc = (SocketChannel) key.channel();
		while (buf.hasRemaining()) {
			sc.write(buf);
		}
		buf.compact();
	}

	/**
	 * 与Selector一起使用时，Channel必须处于非阻塞模式下。
	 * 这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。而套接字通道都可以。
	 */
	public static void selector() {
		Selector selector = null;
		ServerSocketChannel ssc = null;
		try {
			//创建 selector
			selector = Selector.open();
			//打开 ServerSocketChannel
			ssc = ServerSocketChannel.open();
			ssc.socket().bind(new InetSocketAddress(PORT));
			ssc.configureBlocking(false);
			//将Channel注册到Selector上
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			while (true) {
				//最长会阻塞timeout毫秒
				if (selector.select(TIMEOUT) == 0) {
					System.out.println("==");
					continue;
				}
				//一旦调用了select()方法，并且返回值表明有一个或更多个通道就绪
				//访问“已选择键集（selected key set）”中的就绪通道
				Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
				//监听四种不同类型的事件(interest集合)
				while (iter.hasNext()) {
					SelectionKey key = iter.next();
					if (key.isAcceptable()) {
						//监听新进来的连接
						handleAccept(key);
					}
					if (key.isReadable()) {
						handleRead(key);
					}
					if (key.isWritable() && key.isValid()) {
						handleWrite(key);
					}
					if (key.isConnectable()) {
						System.out.println("isConnectable = true");
					}
					//Selector不会自己从已选择键集中移除SelectionKey实例。
					//必须在处理完通道时自己移除。下次该通道变成就绪时，Selector会再次将其放入已选择键集中。
					iter.remove();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (selector != null) {
					selector.close();
				}
				if (ssc != null) {
					ssc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
