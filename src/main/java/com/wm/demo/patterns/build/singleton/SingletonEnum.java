package com.wm.demo.patterns.build.singleton;

/**
 * 可以防止【反射】构建多个实例
 */
public class SingletonEnum {
	
	private enum MyEnumSingleton{
    	INSTANCE;
    	private Object obj;
    	
    	private MyEnumSingleton(){
    		obj = new Object();
    	}
    	
    	public Object initObject(){
    		return obj;
    	}
    }
    
    public static Object getInstance(){
    	return MyEnumSingleton.INSTANCE.initObject();
    }
}
