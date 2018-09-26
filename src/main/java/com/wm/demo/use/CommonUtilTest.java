package com.wm.demo.use;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class CommonUtilTest {

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
		String html = StringEscapeUtils.escapeHtml("<span>123sdf</span>");
		System.out.println(html);
		
		System.out.println(StringEscapeUtils.unescapeHtml(html));
	}
	
	@Test
	public void testCollection() {
		List<String> list = new ArrayList<String>();
		boolean c = CollectionUtils.isEmpty(list);
		System.out.println(c);
	}
	
}
