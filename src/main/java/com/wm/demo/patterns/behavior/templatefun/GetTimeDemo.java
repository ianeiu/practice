package com.wm.demo.patterns.behavior.templatefun;

/**
 * 定义一个算法的骨架，而将具体的算法延迟到子类中来实现
 * 
 * 使用模版方法模式，在定义算法骨架的同时，可以很灵活的实现具体的算法，满足用户灵活多变的需求
 * 
 * 如果算法骨架有修改的话，则需要修改抽象类
 */
public class GetTimeDemo {
	public static void main(String[] args) {
		// GetTime gt = new GetTime();
		// System.out.println(gt.getTime() + "毫秒");

		GetTime gt = new ForDemo();
		System.out.println(gt.getTime() + "毫秒");

		gt = new IODemo();
		System.out.println(gt.getTime() + "毫秒");
	}
}
