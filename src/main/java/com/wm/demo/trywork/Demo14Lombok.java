package com.wm.demo.trywork;

import java.util.Arrays;

import com.wm.demo.trywork.vo.UserVO;

public class Demo14Lombok {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		UserVO vo = new UserVO();
		vo.setSex("1");
		vo.setSexDesc("男");
		vo.setUserId("11");
		vo.setUserName("wm");
		vo.setList(Arrays.asList("1","2","3"));
		
		UserVO vo2 = (UserVO) vo.clone();
		
		System.out.println(vo2);
		
		System.out.println(vo.equals(vo2));//true lombok重写了equals和hash
	}
	
}
