package com.wm.demo.trywork;

import org.apache.commons.lang.ObjectUtils;

import com.wm.demo.trywork.vo.UserPO;

public class Demo16ObjectUtil {
	public static void main(String[] args) {
		UserPO po = new UserPO();
		po.setSex("1");
		po.setUserId("11");
		po.setUserName("1212");
		po.setAge(123L);
		
		UserPO po2 = new UserPO();
		po2 = (UserPO) ObjectUtils.clone(po);
		System.out.println(po2);
		//null
		
		UserPO po3 = new UserPO();
		po3 =po;//指向同一对象
		System.out.println(po3);
		//UserPO(userId=11, userName=1212, sex=1, age=123)

	}
}
