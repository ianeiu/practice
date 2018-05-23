package com.wm.utils.json;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;



import com.wm.utils.json.ref.Base64JsonValueProcesser;
import com.wm.utils.json.ref.CycleDetectionStrategyImpl;
import com.wm.utils.json.ref.DateJsonValueProcesser;
import com.wm.utils.json.ref.DateTimeJsonValueProcesser;
import com.wm.utils.json.ref.DefaultDefaultValueProcessor;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.xml.XMLSerializer;

public class JSONUtil {
	private static final  JsonConfig config = new JsonConfig();
	static{
		config.registerDefaultValueProcessor(Boolean.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Integer.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Double.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Float.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Short.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Long.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(BigInteger.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(BigDecimal.class, new DefaultDefaultValueProcessor());
		config.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcesser("yyyy-MM-dd HH:mm:ss.SSS"));
	}
	public static String objectToString(Object o){
		JSONObject json = null;
        json = JSONObject.fromObject(o, config);
        return json.toString();
	}
	public static String arrayToString(Object o){
		JSONArray json = null;
        json = JSONArray.fromObject(o, config);
        return json.toString();
	}
	public static <T> T stringToObject(String jsonStr,Class<T> clazz){
		JSONObject json = null;
        json = JSONObject.fromObject(jsonStr, config);
        return (T)JSONObject.toBean(json, clazz);
	}
	public static <T> List<T> stringToObjectList(String jsonStr,Class<T> clazz){
		JSONArray json = null;
        json = JSONArray.fromObject(jsonStr);
        return (List<T>)JSONArray.toList(json, clazz);
	}
	
	public static Object stringToObjectArray(String jsonStr,Class clazz){
		JSONArray json = null;
        json = JSONArray.fromObject(jsonStr);
        return JSONArray.toArray(json, clazz);
	}
	public static String objectToString(Object o,String... excludes){
		JSONObject json = null;
		JsonConfig config = new JsonConfig();
		config.setExcludes(excludes);
		config.setCycleDetectionStrategy(new CycleDetectionStrategyImpl());
		
		config.registerDefaultValueProcessor(Boolean.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Integer.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Double.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Float.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Short.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Long.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(BigInteger.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(BigDecimal.class, new DefaultDefaultValueProcessor());
		
        config.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcesser("yyyy-MM-dd HH:mm:ss"));
        config.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcesser("yyyy-MM-dd"));
        config.registerJsonValueProcessor(java.sql.Time.class, new DateJsonValueProcesser("HH:mm:ss"));
        config.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcesser("yyyy-MM-dd HH:mm:ss.SSS"));
        
        
        json = JSONObject.fromObject(o, config);
        return json.toString();
	}
	public static String arrayToString(Object o,String... excludes){
		JSONArray json = null;
		JsonConfig config = new JsonConfig();
		config.setExcludes(excludes);
		config.setCycleDetectionStrategy(new CycleDetectionStrategyImpl());
		
		config.registerDefaultValueProcessor(Boolean.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Integer.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Double.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Float.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Short.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Long.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(BigInteger.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(BigDecimal.class, new DefaultDefaultValueProcessor());
		
        config.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcesser("yyyy-MM-dd HH:mm:ss"));
        config.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcesser("yyyy-MM-dd"));
        config.registerJsonValueProcessor(java.sql.Time.class, new DateJsonValueProcesser("HH:mm:ss"));
        config.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcesser("yyyy-MM-dd HH:mm:ss.SSS"));
        
        json = JSONArray.fromObject(o, config);
        return json.toString();
	}
	public static String xmlToJsonString(String xml){
		XMLSerializer xmlSerializer = new XMLSerializer();
		return xmlSerializer.read(xml).toString();
	}
	public static String urlToJsonString(String url,String charset)throws Exception{
		HttpURLConnection con =  (HttpURLConnection)new URL(url).openConnection();
		con.setInstanceFollowRedirects(false);
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setConnectTimeout(1000*60*1) ;//设置1分钟超时
		
		//设置POST的数据
		BufferedOutputStream bo = new BufferedOutputStream(con.getOutputStream());
		bo.flush();
		con.getOutputStream().close();
		//获取返回值
		BufferedReader bi =new BufferedReader(new InputStreamReader(con.getInputStream(),charset));
		String sCurrentLine = "";   
		String rstXml = "";   
		while((sCurrentLine = bi.readLine()) != null){
			rstXml += sCurrentLine;
		}
		con.getInputStream().close();
		return xmlToJsonString(rstXml);
	}
	public static String objectToStringJs(Object o,String... excludes){
		JSONObject json = null;
		JsonConfig config = new JsonConfig();
		config.registerDefaultValueProcessor(Boolean.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Integer.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Double.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Float.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Short.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Long.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(BigInteger.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(BigDecimal.class, new DefaultDefaultValueProcessor());
		config.setExcludes(excludes);
		config.setCycleDetectionStrategy(new CycleDetectionStrategyImpl());
        config.registerJsonValueProcessor(java.util.Date.class,new DateTimeJsonValueProcesser());
        config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateTimeJsonValueProcesser());
        config.registerJsonValueProcessor(java.io.File.class, new Base64JsonValueProcesser());
        config.registerJsonValueProcessor(java.io.InputStream.class, new Base64JsonValueProcesser());
        json = JSONObject.fromObject(o, config);
        return json.toString();
	}
	public static String arrayToStringJs(Object o,String... excludes){
		JSONArray json = null;
		JsonConfig config = new JsonConfig();
		config.registerDefaultValueProcessor(Boolean.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Integer.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Double.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Float.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Short.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(Long.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(BigInteger.class, new DefaultDefaultValueProcessor());
		config.registerDefaultValueProcessor(BigDecimal.class, new DefaultDefaultValueProcessor());
		config.setExcludes(excludes);
		config.setCycleDetectionStrategy(new CycleDetectionStrategyImpl());
        config.registerJsonValueProcessor(java.util.Date.class, new DateTimeJsonValueProcesser());
        config.registerJsonValueProcessor(java.sql.Timestamp.class,new DateTimeJsonValueProcesser());
        config.registerJsonValueProcessor(java.io.File.class, new Base64JsonValueProcesser());
        config.registerJsonValueProcessor(java.io.InputStream.class, new Base64JsonValueProcesser());
        json = JSONArray.fromObject(o, config);
        return json.toString();
	}
}
