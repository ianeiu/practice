package com.wm.demo.trywork;

public class Demo07IntegerInt {
	Integer a = 1000,b=1000;
	Integer c = 100,d=100;   
	Integer e = new Integer(10);
	Integer f = new Integer(10);
	int g = 1000;
	Integer h = new Integer(1000);	
	public void mRun(){
		//1、进行自动装箱操作；2、Integer中把-128-127 缓存了下来
	    System.out.println(a==b);//false  
		System.out.println(c==d);//true
		
		//这里的Integer是我们自己new出来的，并不是用的缓存，所以结果是false
		System.out.println(e==f);//false
		//当int和Integer进行==比较的时候，Java会把Integer进行自动拆箱，int类型的值
		System.out.println(b==h);//true
    }
	
	public static void main(String[] args) {
		new Demo07IntegerInt().mRun();
	}
}
