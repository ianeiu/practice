package com.wm.demo.patterns.build.singleton;

/**
 * JVM编译器的指令重排，可能会得到一个没有初始化的对象

java中简单的一句 instance = new Singleton，会被编译器编译成如下JVM指令：
memory =allocate();    //1：分配对象的内存空间 
ctorInstance(memory);  //2：初始化对象 
instance =memory;     //3：设置instance指向刚分配的内存地址 

但是这些指令顺序并非一成不变，有可能会经过JVM和CPU的优化，指令重排成下面的顺序：

memory =allocate();    //1：分配对象的内存空间 
instance =memory;     //3：设置instance指向刚分配的内存地址 
ctorInstance(memory);  //2：初始化对象 

当线程A执行完1,3,时，instance对象还未完成初始化，但已经不再指向null。
此时如果线程B抢占到CPU资源，执行  if（instance == null）的结果会是false，从而返回一个没有初始化完成的instance对象。

如何避免这一情况呢？我们需要在instance对象前面增加一个修饰符volatile。
 */
public class Singleton3 {
    private static volatile Singleton3 _instance;

    /**
     * Double checked locking code on Singleton
     * @return Singelton instance
     */
    public static Singleton3 getInstance() {
    	//双重检测机制
        if (_instance == null) {
        	//同步锁
            synchronized (Singleton3.class) {
            	//双重检测机制
                if (_instance == null) {
                    _instance = new Singleton3();
                }
            }
        }
        return _instance;
    }
}
