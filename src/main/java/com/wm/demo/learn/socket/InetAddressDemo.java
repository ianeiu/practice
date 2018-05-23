package com.wm.demo.learn.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * InetAddress的成员方法：
 * public static InetAddress getByName(String host):根据主机名或者IP地址的字符串表示得到IP地址对象
 */
public class InetAddressDemo {
	public static void main(String[] args) throws IOException {
		InetAddress ia = InetAddress.getByName("192.168.1.101");
		// InetAddress ia = InetAddress.getByName("www.baidu.com");
		// InetAddress ia = InetAddress.getByName("www.taobao.com");
		// InetAddress ia = InetAddress.getByName("www.sina.com");;
		// InetAddress ia = InetAddress.getByName("www.weibo.com");
		String name = ia.getHostName();//获取主机名
		String address = ia.getHostAddress();//获取IP地址
		System.out.println(name + "--" + address);
	}
}
