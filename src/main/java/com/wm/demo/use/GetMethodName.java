package com.wm.demo.use;

import org.junit.Test;

/**
 * 
 * @author admin
 *
 */
public class GetMethodName {
	
	@Test
	public void getMethodName(){
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(methodName);
	}
}
