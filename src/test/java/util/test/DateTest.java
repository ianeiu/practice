package util.test;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;

import com.wm.utils.date.DateUtils;

public class DateTest {

	
	@Test
	public void getDateStr(){
		System.out.println(DateUtils.convertToString(new java.util.Date(), "yMM"));
	}
	
	@Test
	public void daysBetween(){
		Date date = DateUtils.convertToDate("2017-09-19",Date.class);
		Date d = new Date();
		System.out.println(DateUtils.betweenDays(date, d));
		System.out.println(DateUtils.betweenMins(date, d));
	}
	
	@Test
	public void compareToCurrentDate(){
		Date date = DateUtils.convertToDate("2017-09-23",Date.class);
		System.out.println(DateUtils.compareToCurrentDate(date));
	}
	
	@Test
	public void convertToString(){
		Time time = new Time(1, 1, 1);
		String s = DateUtils.convertToString(time);
		System.out.println(s);
	}
	
}
