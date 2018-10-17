package com.wm.demo.javabase.collectionAmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Demo14Map {
	public static void main(String[] args) {
		
		Map<String,String> mp = new HashMap<>();
		
		mp.put("wwm", "DaShuaiBi");
		mp.put("wm", "shuai");
		mp.put("wm", "TaiShuai");
		mp.put("Wm", "shuai");
		
		
		//mp.clear();
		//mp.remove("Wm");
		System.out.println("remove:" + mp.remove("Wm"));//shuai
		System.out.println("remove:" + mp.remove("W"));//null
		System.out.println("containsKey:"+mp.containsKey("wwm"));//true
		System.out.println("isEmpty:"+mp.isEmpty());
		System.out.println("size:"+mp.size());
		System.out.println("get:"+mp.get("wm"));
		
		Set<String> set = mp.keySet();
		for(String key:set){
			String value = mp.get(key);
			System.out.println(key+"----"+value);
		}
		
		Collection<String> set2 = mp.values();
		for(String value:set2){
			System.out.println(value);
		}

		Set<Map.Entry<String, String>> set3 = mp.entrySet();
		for(Map.Entry<String, String> map : set3){
			String key = map.getKey();
			String value = map.getValue();
			System.out.println(key+"--"+value);
		}
		
		System.out.println(mp);
		System.out.println("-------------------------");
		
		TreeMap<Demo14Student,String> tm = new TreeMap<>(
				new Comparator<Demo14Student>() {
					public int compare(Demo14Student o1, Demo14Student o2) {
						int num = o1.getAge()-o2.getAge();
						int num2 = num==0?o1.getName().compareTo(o2.getName()):num;
						return num2;
					}
		});//学生对象作为键
		
		Demo14Student s1 = new Demo14Student("潘安", 30);
		Demo14Student s2 = new Demo14Student("柳下惠", 35);
		Demo14Student s3 = new Demo14Student("唐伯虎", 33);
		Demo14Student s4 = new Demo14Student("燕青", 32);
		Demo14Student s5 = new Demo14Student("唐伯虎", 33);
		
		tm.put(s1, "宋朝");
		tm.put(s2, "元朝");
		tm.put(s3, "明朝");
		tm.put(s4, "清朝");
		tm.put(s5, "汉朝");
		
		Set<Demo14Student> stm = tm.keySet();
		
		for(Demo14Student key:stm){
			String value = tm.get(key);
			System.out.println(key.getName()+" "+key.getAge()+" --- "+value);
		}
	}
}
