package com.wm.sf;

/*
需求：请输出下列的形状
	*
	**
	***
	****
	*****
需求：在控制台输出九九乘法表。
*/	
public class NineNineCF {
	
	public static void main(String[] args) {
		for(int x=0; x<5; x++) {
			for(int y=0; y<=x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int x=1; x<=9; x++) {
			for(int y=1; y<=x; y++) {
				System.out.print(y+"*"+x+"="+y*x+"\t");
			}
			System.out.println();
		}
	}
}
