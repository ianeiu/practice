package com.wm.demo.writeexam;

public class YuFaVar {
	private String s = "abc";
	private static int i =1 ;
	
	public YuFaVar(){
		//doSomeThing();
	}
	
	static{
		i =1;
		//s ="abc";
	}
	
	public YuFaVar(int i,String s){
		i=1;
		s="abc";
	}
	
	
	
	@Override
	public String toString() {
		return "YuFa [s=" + s + ",i=" + i + "]";
	}



	public static void main(String[] args) {
		YuFaVar yf = new YuFaVar();
		System.out.println(yf);
		YuFaVar yf2 = new YuFaVar(2,"abc");
		System.out.println(yf2);
	}
}
