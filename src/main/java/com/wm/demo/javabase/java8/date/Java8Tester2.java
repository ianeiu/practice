package com.wm.demo.javabase.java8.date;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 使用时区的日期时间API
 * 
 * @author wm
 *
 */
public class Java8Tester2 {
	public static void main(String args[]) {
		Java8Tester2 java8tester = new Java8Tester2();
		java8tester.testZonedDateTime();
	}

	public void testZonedDateTime() {

		// 获取当前时间日期
		//ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
		
		ZonedDateTime date1 = ZonedDateTime.now();
		System.out.println("date1: " + date1);

		ZoneId id = ZoneId.of("Europe/Athens");
		System.out.println("ZoneId: " + id);

		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("当期时区: " + currentZone);
	}
}
