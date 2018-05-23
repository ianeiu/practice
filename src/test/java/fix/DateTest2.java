package fix;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;

public class DateTest2 {
	
	@Test
	public void parseDate(){
		Date date = null;
		try {
			date = DateUtils.parseDate("2017-07-17", "yyyy-MM-dd","yyyy-MM");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(DateFormatUtils.format(date,"yyyy-MM-dd"));
		
		FastDateFormat.getTimeInstance(1);
	}

}
