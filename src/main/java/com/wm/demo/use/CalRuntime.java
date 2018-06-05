package com.wm.demo.use;

public class CalRuntime {
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();    //获取开始时间
		doSomeThing();
		long endTime = System.currentTimeMillis();    //获取结束时间
		System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
		
		//以纳秒为单位计算
		long startTime2=System.nanoTime();   //获取开始时间  
		doSomeThing(); //测试的代码段  
		long endTime2=System.nanoTime(); //获取结束时间  
		System.out.println("程序运行时间： "+(endTime2-startTime2)+"ns"); 
	}
	
	private static void doSomeThing(){
		for(int i=0;i<100;i++){
			System.out.println(i);
		}
	}
	
	
}
