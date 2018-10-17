package com.wm.demo.javabase.thread.main;

import com.wm.demo.javabase.thread.vo.MyRunable;
import com.wm.demo.javabase.thread.vo.MyThread;

public class ThreadDemo {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());// main
		
		MyThread m1 = new MyThread();
		m1.setName("kakaka");
		MyThread m2 = new MyThread("he");
		MyThread m3 = new MyThread("papa");

		// System.out.println(m2.getPriority());
		// m3.setPriority(9);//将m3的优先级设置为9

		// m1.setDaemon(true);
		// m2.setDaemon(true);
		// m3.setDaemon(true);
		// Thread.currentThread().setName("大哥");
		// for (int x = 0; x < 5; x++) {
		// System.out.println(Thread.currentThread().getName() + ":" + x);
		// }

		m1.start();

		// try {
		// m1.join();// 加入，让m1先执行完
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		m2.start();
		m3.start();

		try {
			Thread.sleep(3000);
			// m1.stop();  //不报错
			m1.interrupt();
			m2.interrupt();
			m3.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//---------------------------------------------------
		
		MyRunable mr = new MyRunable();
		Thread t1 = new Thread(mr);
		t1.setName("balabala");
		Thread t2 = new Thread(mr,"bilibili");
		
		t1.start();
		t2.start();
	}
}
