package com.wm.demo.trywork;

public class Demo04YuFa {
	private String s = "abc";
	private static int i =1 ;
	
	public Demo04YuFa(){
		//doSomeThing();
	}
	
	static{
		i =1;
		//s ="abc";
	}
	
	public Demo04YuFa(int i,String s){
		i=1;
		s="abc";
	}
	
	public static void main(String[] args) {
		Demo04YuFa yf = new Demo04YuFa();
		Demo04YuFa yf2 = new Demo04YuFa(1,"abc");
	}
}
