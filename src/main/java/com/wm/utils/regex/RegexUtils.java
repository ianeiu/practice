package com.wm.utils.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: regexUtils
 * @author: wm
 * @date: 2018年9月17日 上午10:38:13
 * @version: 1.0
 */
public class RegexUtils {

	/**
	 * 
	 * @param html
	 * @return 获得网页标题
	 */
	public static String getTitle(String html) {
		String regex= "<title>.*?</title>";
		String title = "";
		final List<String> list = new ArrayList<String>();
		final Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);
		final Matcher ma = pa.matcher(html);
		while (ma.find()) {
			list.add(ma.group());
		}
		for (int i = 0; i < list.size(); i++) {
			title = title + list.get(i);
		}
		return title.replaceAll("<.*?>", "");
	}


	/**
	 * 获取标签中的值
	 * @param html  内容
	 * @param regex  正则表达式
	 * @return 
	 */
	public static List<String> getLabelValues(String html,String regex) {
		final List<String> list = new ArrayList<String>();
		final Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);
		final Matcher ma = pa.matcher(html);
		while (ma.find()) {
			list.add(ma.group().replaceAll("<.*?>", ""));
		}
		return list;
	}
		
	/**
	 * 获取匹配的正则表达式
	 * 
	 * @param s  内容
	 * @param regex   正则表达式
	 * @return
	 */
	public static List<String> getContentByRegex(String s, String regex) {

		final List<String> list = new ArrayList<String>();
		// 获得页面所有的链接
		final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
		final Matcher ma = pa.matcher(s);
		while (ma.find()) {
			list.add(ma.group());
		}
		return list;
	}

	/**
	 * 
	 * @param s
	 * @return 获得所有的超链接
	 */
	public static List<String> getLink(String s) {
		String regex = "<a[^>]*href=(\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))[^>]*>(.*?)</a>";
		final List<String> list = new ArrayList<String>();
		final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
		final Matcher ma = pa.matcher(s);
		while (ma.find()) {
			list.add(ma.group());
		}
		return list;
	}

	/**
	 * 获取指定HTML标签的指定属性的值 
	 * @param source  要匹配的源文本
	 * @param element  标签名称
	 * @param attr 标签的属性名称
	 * @return 属性值列表
	 */
	public static List<String> match(String source, String element, String attr) {
		List<String> result = new ArrayList<String>();
		String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
		Matcher m = Pattern.compile(reg).matcher(source);
		while (m.find()) {
			String r = m.group(1);
			result.add(r);
		}
		return result;
	}

}
