package com.wm.demo.javabase.socket.udp;

import java.io.IOException;
import java.net.DatagramSocket;

public class ChatRoom {
	public static void main(String[] args) throws IOException {
		DatagramSocket reDs = new DatagramSocket(2233);
		DatagramSocket seDs = new DatagramSocket();
		
		ReceiveThread rt = new ReceiveThread(reDs);
		SendThread st = new SendThread(seDs);
		
		Thread reT = new Thread(rt);
		Thread seT = new Thread(st);
		
		reT.start();
		seT.start();
	}
}
