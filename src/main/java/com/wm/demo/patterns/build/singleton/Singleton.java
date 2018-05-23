package com.wm.demo.patterns.build.singleton;


//懒汉模式（可能出问题）
//A:懒加载（延迟加载）
//B:线程安全问题
public class Singleton{
	private static Singleton sl = null;

	private Singleton(){}

	public synchronized static Singleton getInstance(){
		if(sl==null){
			sl = new Singleton();
		}
		return sl;
	}
}