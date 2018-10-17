package com.wm.demo.javabase.thread.vo;

public class MyThread extends Thread {

	public MyThread() {

	}

	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("开始");
			try {
				Thread.sleep(10);//休眠10毫秒
			} catch (InterruptedException e) {
				System.out.println("线程被终止了");
			}
			System.out.println(getName() + "--" + i);
			//Thread.yield();//礼让，尽可能让多个线程分配资源
		}
	}

}
