package com.wm.demo.use;

import java.util.List;

import com.wm.utils.http.HttpRequestSimple;
import com.wm.utils.regex.RegexUtils;

/**
 * @Description: HTML解析
 * @author: wm
 * @date: 2018年9月17日 上午9:45:33
 * @version: 1.0
 */
public class HTMLParser {
	
	public static void main(String[] args) {
		
		try {
			String content = HttpRequestSimple.sendGet("http://127.0.0.1:8080/test/89b9c0b6-ed23-43d1-9803-401f484bcb2c/", "");
			String regex = "<a[^>]*href=(\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))[^>]*><tt>(.*?)/</tt></a>";
			List<String> links = RegexUtils.getContentByRegex(content, regex); 
					
			for (String link : links) {
				String s = link.replaceAll("<.*?>", "");
				System.out.println(s.substring(0, s.length()-1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    

	
}
