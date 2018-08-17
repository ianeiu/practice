package com.wm.demo.trywork;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.wm.demo.trywork.vo.UserPO;
import com.wm.demo.trywork.vo.UserVO;

public class Demo13SpringBeanUtil {
	@Test
	public void testCopy() throws IllegalAccessException, InvocationTargetException{
		UserVO vo = new UserVO();
		vo.setList(new ArrayList<>());
		vo.setSex("1");
		vo.setSexDesc("男");
		vo.setUserId("weimian");
		vo.setUserName("吾未眠");
	
		UserPO po = new UserPO();
		BeanUtils.copyProperties(vo, po);
		System.out.println(po);
	}
}
