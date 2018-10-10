package com.wm.demo.trywork;

import java.util.HashSet;
import java.util.Set;

import com.wm.demo.trywork.vo.UserVO;

public class DemoOOM {
	public static void main(String[] args){
		Set<UserVO> set = new HashSet<>();
		UserVO p1 = new UserVO("唐僧","pwd1","11");
		UserVO p2 = new UserVO("孙悟空","pwd2","11");
		UserVO p3 = new UserVO("猪八戒","pwd3","11");
		set.add(p1);
		set.add(p2);
		set.add(p3);
		System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!
		p3.setSex("22");//修改p3的年龄,此时p3元素对应的hashcode值发生改变

		set.remove(p3); //此时remove不掉，造成内存泄漏

		set.add(p3); //重新添加，居然添加成功
		System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:4 个元素!
		for (UserVO UserVO : set){
			System.out.println(UserVO);
		}
	}
}
