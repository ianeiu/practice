package com.wm.demo.patterns.strut.decorate;

public class MusicPhoneDecorate extends PhoneDecorate {

	public MusicPhoneDecorate(Phone p) {
		super(p);
	}

	@Override
	public void call() {
		super.call();
		System.out.println("手机可以听音乐");
	}
}
