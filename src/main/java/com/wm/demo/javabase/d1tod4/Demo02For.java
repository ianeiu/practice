package com.wm.demo.javabase.d1tod4;

import org.junit.Test;

public class Demo02For {
	
	/*
		需求：求5的阶乘。
		
		什么是阶乘呢?
			n! = n*(n-1)! 规则
			n! = n*(n-1)*(n-2)*...*3*2*1
			
		求和思想。
		求阶乘思想。
	*/
	@Test
	public void testJieCheng() {
		//定义最终结果变量
		int jc = 1;
		
		//这里的x其实可以直接从2开始
		//for(int x=1; x<=5; x++) 
		
		for(int x=2; x<=5; x++) {
			jc *=x;
		}
		
		System.out.println("1-5的阶乘是："+jc);
	}
	
	/*
		需求：在控制台输出所有的”水仙花数”
		
		分析：
			我们都不知道什么叫"水仙花数"，你让我怎么做呢?
			
			所谓的水仙花数是指一个三位数，其各位数字的立方和等于该数本身。
			举例：153就是一个水仙花数。
			153 = 1*1*1 + 5*5*5 + 3*3*3 = 1 + 125 + 27 = 153
	
			A:三位数其实是告诉了我们范围。
			B:通过for循环我们就可以实现获取每一个三位数
			  但是麻烦是如何获取这个三位数的个,十,百位上的数据
			  
			  我们如何获取一个数据的个,十,百呢?
				假设有个一个数据:153
				ge:	153%10 = 3
				shi: 153/10%10 = 5
				bai：153/10/10%10 = 1
				qian：x/10/10/10%10
				wan:  x/10/10/10/10%10
				...
	
			C:让ge*ge*ge+shi*shi*shi+bai*bai*bai和该数据比较
			  如果相同，就把该数据在控制台输出。
	*/	
	@Test
	public void testShuiXianHua() {
		//三位数其实是告诉了我们范围。
		for(int x=100; x<1000; x++) {
			int ge = x%10;
			int shi = x/10%10;
			int bai = x/10/10%10;
			
			//让ge*ge*ge+shi*shi*shi+bai*bai*bai和该数据比较
			if(x == (ge*ge*ge+shi*shi*shi+bai*bai*bai)) {
				//如果相同，就把该数据在控制台输出。
				System.out.println(x);
			}
		}
	}

	/*
		需求：请输出下列的形状
			*
			**
			***
			****
			*****
		需求：在控制台输出九九乘法表。
	*/	
	@Test
	public void testForFor() {
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
	
	@Test
	public void testBreak() {
		wc:for(int x=0; x<3; x++) {
			nc:for(int y=0; y<4; y++) {
				if(y == 2) {
					//break nc;
					break wc;
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
