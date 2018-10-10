package com.wm.demo.trywork;

import org.junit.Test;

public class Demo02IntegerParam {
	
	@Test
	public void testIntergerFun() {
		
		//Integer i = 6;//6
		Integer i = new Integer(6);//6
		change(i);
		System.out.println(i);
	}

	private static void change(Integer i) {
		i++;
	}
	
	
	
	
}
