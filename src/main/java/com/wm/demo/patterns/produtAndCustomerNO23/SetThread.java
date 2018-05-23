package com.wm.demo.patterns.produtAndCustomerNO23;

public class SetThread implements Runnable {

	private Student s;
	private int x = 0;

	public SetThread(Student s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			if (x % 2 == 0) {
				s.set("wm", 12);
			} else {
				s.set("mw", 21);
			}
			x++; //x=1
		}
	}
}
