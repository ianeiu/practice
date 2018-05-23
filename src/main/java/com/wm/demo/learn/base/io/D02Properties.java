package com.wm.demo.learn.base.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;
import java.util.Set;

/**
 * Properties:属性集合类。是一个可以和IO流相结合使用的集合类。 
 * Properties可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。
 * 
 * 是Hashtable的子类，说明是一个Map集合。
 * 
 * 特殊功能：
 * public Object setProperty(String key,String value)：添加元素
 * public String getProperty(String key):获取元素 
 * public Set<String> stringPropertyNames():获取所有的键的集合
 * 
 * 这里的集合必须是Properties集合：
 * public void load(Reader reader):把文件中的数据读取到集合中 
 * public void store(Writer writer,String comments):把集合中的数据存储到文件
 * 
 * @author WM
 *
 */
public class D02Properties {
	public static void main(String[] args) {
		try {
			baseFun();
			moreFun();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void moreFun() {
		// TODO Auto-generated method stub
		
	}

	private static void baseFun() throws IOException {
		//Map功能
		Properties pro = new Properties();
		pro.put("wm", "123");
		pro.put("it001", "world");
		pro.put("it003", "java");
		Set<Object> set = pro.keySet();
		for (Object key : set) {
			Object value = pro.get(key);
			System.out.println(key + "---" + value);
		}
		
		//特有功能
		Properties prop = new Properties();
		prop.setProperty("张三", "30");
		prop.setProperty("李四", "40");
		prop.setProperty("王五", "50");
		Set<String> set2 = prop.stringPropertyNames();
		for (String key : set2) {
			String value = prop.getProperty(key);
			System.out.println(key + "---" + value);
		}
		
		//结合IO写
		Properties proper = new Properties();
		proper.setProperty("张三", "30");
		proper.setProperty("李四", "40");
		proper.setProperty("王五", "50");
		Writer w = new FileWriter("name.txt");
		proper.store(w, "helloworld");//第二个参数注释
		w.close();
		
		//结合IO读
		Properties prope = new Properties();
		Reader r = new FileReader("prop.txt");
		prope.load(r);
		r.close();
		System.out.println("prop:" + prop);
	}
}
