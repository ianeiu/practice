package util.test;

import java.util.Map;

import org.dom4j.DocumentException;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.wm.utils.json.XmlTool;

public class XmlToolTest {

	@Test
	public void testXML() throws DocumentException{
		String xml ="<?xml version=\"1.0\"?>"
+"<students> "
  +"<student> "
    +"<name>John</name>" 
    +"<grade>B</grade> "
    +"<age>12</age> "
    +"</student> "
  +"<student> "
  +"<name>Mary</name>" 
    +"<grade>A</grade>" 
    +"<age>11</age> "
    +"</student> "
  +"<student> "
  +"<name>Simon</name>" 
    +"<grade>A</grade> "
    +"<age>18</age> "
    +"</student> "
  +"</students>";
		JSONObject jo = XmlTool.documentToJSONObject(xml);
		Map<String, Object> map = jo;
		System.out.println("通过Map.keySet遍历key和value：");
		for (String key : map.keySet()) {
			System.out.println("key= " + key + " and value= " + map.get(key));
		}
	}
}
