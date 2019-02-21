package com.wm.demo.use;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: HTML解析
 * @author: wm
 * @date: 2018年9月17日 上午9:45:33
 * @version: 1.0
 */
public class HTMLParser {
	
	public static void main(String[] args) {
		
		try {
			String content = sendGet("http://127.0.0.1:8080/test/89b9c0b6-ed23-43d1-9803-401f484bcb2c/", "");
			String regex = "<a[^>]*href=(\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))[^>]*><tt>(.*?)/</tt></a>";
			List<String> links = getContentByRegex(content, regex); 
					
			for (String link : links) {
				String s = link.replaceAll("<.*?>", "");
				System.out.println(s.substring(0, s.length()-1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * 向指定URL发送GET方法的请求
     * 
     * @param url 发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     * @throws IOException 
     */
    public static String sendGet(String url, String param) throws IOException {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } 
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
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

	
}
