package com.wm.demo.javabase.collectionAmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class Demo13Collection {
	
	@Test
	public void testCollection() {
		Collection c = new ArrayList();
		c.add("Wwm");
		c.add("Hen");
		c.add("ZeiChacha");
		c.add("Shuai");
		
		System.out.println("remove:"+c.remove("ZeiChacha"));//移除某个元素
		System.out.println("contains:"+c.contains("Wwm"));//判断是否包含Wwm
		System.out.println("isEmpty:"+c.isEmpty());//判断是否为空
		System.out.println("元素个数size："+c.size());//获取元素个数
		System.out.println(c);
		//c.clear();//清空list
		System.out.println(c);
		System.out.println("----------------------------");
		
		Collection c2 = new ArrayList();
		c2.add("Wu");
		c2.add("Wei");
		c2.add("Mian");
		c2.add("Hen");
		Collection c3 = new ArrayList();
		c3.add("Wu");
		c3.add("Wei");
		c3.add("Mian");
		
		System.out.println("addAll:"+c.addAll(c2));
		System.out.println(c+"\n"+c2);
		System.out.println("removeAll:"+c.removeAll(c2));//移除c中与c2中任意一个元素相同的元素
		System.out.println(c+"\n"+c2);
		System.out.println("containsAll:"+c.containsAll(c2));//若c中包含了c2的所有元素，返true
		System.out.println("retainAll:"+c3.retainAll(c2));//c3保存了c3与c2交集的元素，返c3是否发生改变
		System.out.println(c3+"\n"+c2);
		System.out.println("----------------------------");
		
		Object[] ob = c3.toArray();
		System.out.print("遍历c3获取每个元素的长度:");
		for(int i=0; i<ob.length;i++){
			String s = (String) ob[i];
			System.out.println("字符串"+s+"的长度："+s.length());
		}		
		System.out.println("-----------------------------");
		System.out.println("-----------迭代器遍历-----------");
		
		Iterator it = c3.iterator();
		while(it.hasNext()){
			String s = it.next()+"  ";
			System.out.print(s);
		}
		System.out.println("");
		System.out.println("-----------------------------");
		
		List list = new ArrayList<>(c3);
		ListIterator lit = list.listIterator();
		while (lit.hasNext()) {
			System.out.println(lit.next());
		}
		System.out.println();
	}
}
