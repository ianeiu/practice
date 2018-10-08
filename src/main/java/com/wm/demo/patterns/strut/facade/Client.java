package com.wm.demo.patterns.strut.facade;

/**
 * MVC架构中比较常见
 * 目的：(封装交互，简化调用)让外部减少与子系统内多个模块的交互，松散耦合，从而让外部能够更简单的使用子系统
 * 
 * 优点：松散耦合、简单易用、更好的划分访问的层次
 * 缺点：过多的或者是不太合理的Facade也容易让人迷惑
 */
public class Client {

	public static void main(String[] args) {
		//使用Facade
		new Facade().test();
	}
}
