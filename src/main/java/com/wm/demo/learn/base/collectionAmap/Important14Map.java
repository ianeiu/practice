package com.wm.demo.learn.base.collectionAmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class Important14Map {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "value1");
		map.put("2", "value2");
		map.put("3", "value3");

		// 第一种：普遍使用，二次取值
		System.out.println("通过Map.keySet遍历key和value：");
		for (String key : map.keySet()) {
			System.out.println("key= " + key + " and value= " + map.get(key));
		}

		// 第二种
		System.out.println("通过Map.entrySet使用iterator遍历key和value：");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("key= " + entry.getKey() + " and value= "
					+ entry.getValue());
		}

		// 第三种：推荐，尤其是容量大时
		System.out.println("通过Map.entrySet遍历key和value");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= "
					+ entry.getValue());
		}
		// 第四种
		System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
		for (String v : map.values()) {
			System.out.println("value= " + v);
		}

	}
	
	private String parseOrderMap(Map<String, Object> searchMap) {
		if (searchMap == null || searchMap.size() == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder("");
		String key = null;
		String value = null;
		
		for (Map.Entry<String, Object> entry : searchMap.entrySet()) {
			key = StringUtils.trim(entry.getKey());
			if(entry == null || entry.getValue()==null ||"".equals(entry.getValue()) ){
				continue;
			}
			if(entry.getValue().getClass().equals(String.class)){
				value = (String)entry.getValue();
				value = StringUtils.trim(value);
			}
			if (StringUtils.equalsIgnoreCase("scode", key)) {
				sb.append(" and psr.s_code ='").append(value).append("'");
			}
			if (StringUtils.equalsIgnoreCase("productName", key)) {
				sb.append(" and pi.PRODUCT_NAME like '").append(value).append("'");
			}
			if (StringUtils.equalsIgnoreCase("productLeibie", key)) {
				sb.append(" and pi.product_leibie = '").append(value).append("'");
			}
		}
		
		return sb.toString();
	}
}
