package com.wm.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	/**
	 * 
	 * @param start ex:06:00
	 * @param end ex:19:59
	 */
	public static boolean isBelong(String start,String end) {

		SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
		Date now = null;
		Date beginTime = null;
		Date endTime = null;
		try {
			now = df.parse(df.format(new Date()));
			beginTime = df.parse(start);
			endTime = df.parse(end);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Boolean flag = belongCalendar(now, beginTime, endTime);
		return flag;
	}

	/**
	 * 判断时间是否在时间段内
	 * 
	 * @param nowTime
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
		return nowTime.getTime() >= beginTime.getTime() && nowTime.getTime() <= endTime.getTime(); 
	}
}
