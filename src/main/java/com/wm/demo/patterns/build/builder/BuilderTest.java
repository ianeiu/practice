package com.wm.demo.patterns.build.builder;

/**
 * 
 * 目的： 把构造对象 细节步骤 隐藏
 * 
	优点
	良好的封装性， 使用建造者模式可以使客户端不必知道产品内部组成的细节；
	建造者独立，容易扩展；
	在对象创建过程中会使用到系统中的一些其它对象，这些对象在产品对象的创建过程中不易得到。
	
 */
public class BuilderTest {
	public static void main(String[] args) {
		Director director = new Director();
		Human human = director.createHumanByDirecotr(new SmartManBuilder());
		System.out.println(human.getHead());
		System.out.println(human.getBody());
		System.out.println(human.getHand());
		System.out.println(human.getFoot());
	}

}
