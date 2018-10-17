package com.wm.demo.javabase.d5tod12;

import java.util.Arrays;

public class Demo09System {
	public static void main(String[] args) {
		System.gc();//一般不用，系统自己会执行
		
		long st = System.currentTimeMillis();
		for(int i = 0; i<100;i++){
			System.out.println(i);
		}
		long ed = System.currentTimeMillis();
		System.out.println("用时"+(ed-st)+"毫秒");
		
		int[] a = {1,5,6,7,88};
		int[] b = {51,58,6,12,32,54};
		//从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
		System.arraycopy(a, 3, b, 2, 1);// 将数组b下标为（2）开始置换成     从数组a下标为（3）开始   取出的（1）个数字
		System.out.println("数组a："+Arrays.toString(a));//数组a：[1, 5, 6, 7, 88]
		System.out.println("数组b："+Arrays.toString(b));//数组b：[51, 58, 7, 12, 32, 54]
		
		System.exit(0);//终止程序
	}
}
