package com.wm.demo.patterns.build.singleton;

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
