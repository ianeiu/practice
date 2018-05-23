package com.wm.demo.learn.base.d5tod12;

import java.util.Calendar;
import java.util.Scanner;

/*
 * Calendar:它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等 日历字段之间的转换
 * 提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。
 * public int get(int field):返回给定日历字段的值。日历类中的每个日历字段都是静态的成员变量，并且是int类型。
 * public void add(int field,int amount):根据给定的日历字段和对应的时间，来对当前的日历进行操作。
 * public final void set(int year,int month,int date):设置当前日历的年月日
 */
public class Demo12Calendar {
	public static void main(String[] args){
		Calendar cl = Calendar.getInstance();
		int year = cl.get(Calendar.YEAR);
		int month = cl.get(Calendar.MONTH)+1;
		int date = cl.get(Calendar.DATE);
		System.out.println(year+"年"+month+"月"+date+"日");
		System.out.println("--------------");
		
		// 5年后的10天前
		cl.add(Calendar.YEAR, 5);
		cl.add(Calendar.DATE, -10);
		// 获取年
		year = cl.get(Calendar.YEAR);
		// 获取月
		month = cl.get(Calendar.MONTH);
		// 获取日
		date = cl.get(Calendar.DATE);
		System.out.println(year + "年" + (month + 1) + "月" + date + "日");
		System.out.println("--------------");
		
		cl.set(2011, 11, 11);
		// 获取年
		year = cl.get(Calendar.YEAR);
		// 获取月
		month = cl.get(Calendar.MONTH);
		// 获取日
		date = cl.get(Calendar.DATE);
		System.out.println(year + "年" + (month + 1) + "月" + date + "日");
	}
	
	public static void main2(String[] args) {
		// 键盘录入任意的年份
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = sc.nextInt();

		// 设置日历对象的年月日
		Calendar c = Calendar.getInstance();
		c.set(year, 2, 1); // 其实是这一年的3月1日
		// 把时间往前推一天，就是2月的最后一天
		c.add(Calendar.DATE, -1);

		// 获取这一天输出即可
		System.out.println(c.get(Calendar.DATE));
	}
}
