package util.test;

import org.junit.Test;

import com.wm.utils.date.TimeUtils;

public class TimeTest {
	@Test
	public void belongTest(){
		
		System.out.println(TimeUtils.isBelong("16:47", "16:55"));
	}
}
