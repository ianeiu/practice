package util.test;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;

import com.wm.utils.date.DateUtil2;

public class DateTest {

	
	@Test
	public void getDateStr(){
		System.out.println(DateUtil2.convertToString(new java.util.Date(), "yMM"));
	}
	
	@Test
	public void daysBetween(){
		Date date = DateUtil2.convertToDate("2017-09-19",Date.class);
		Date d = new Date();
		System.out.println(DateUtil2.betweenDays(date, d));
		System.out.println(DateUtil2.betweenMins(date, d));
	}
	
	@Test
	public void compareToCurrentDate(){
		Date date = DateUtil2.convertToDate("2017-09-23",Date.class);
		System.out.println(DateUtil2.compareToCurrentDate(date));
	}
	
	@Test
	public void convertToString(){
		Time time = new Time(1, 1, 1);
		String s = DateUtil2.convertToString(time);
		System.out.println(s);
	}
	
}
