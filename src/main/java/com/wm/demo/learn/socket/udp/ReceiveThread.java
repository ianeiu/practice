package com.wm.demo.learn.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveThread implements Runnable {
	private DatagramSocket ds;

	public ReceiveThread(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			while (true) {
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);

				ds.receive(dp);

				String address = dp.getAddress().getHostAddress();
				String s = new String(dp.getData(), 0, dp.getLength());
				System.out.println(address + "--" + s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
