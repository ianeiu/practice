package util.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class CommonTest {

	@Test
	public void TestString() {
		boolean isB = StringUtils.isBlank(" ");
		boolean isB2 = StringUtils.isBlank("aaa");
		System.out.println(isB);
		System.out.println(isB2);
		
		String s = StringUtils.EMPTY;
		System.out.println(s);
	}
	
	@Test
	public void TestString2() {
		String isB = org.apache.commons.lang3.StringUtils.capitalize("ccc");
		System.out.println(isB);
	}
	
	@Test
	public void TestStringEsca() {
		String isB = StringEscapeUtils.escapeHtml("<span>123sdf</span>");
		System.out.println(isB);
	}
	
	@Test
	public void testCollection() {
		List<String> list = new ArrayList<String>();
		boolean c = CollectionUtils.isEmpty(list);
		System.out.println(c);
	}
	
}
