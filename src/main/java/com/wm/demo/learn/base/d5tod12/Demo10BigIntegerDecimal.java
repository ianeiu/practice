package com.wm.demo.learn.base.d5tod12;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class Demo10BigIntegerDecimal {

	/**
	 *  BigInteger:可以让超过Integer范围内的数据进行运算
	 */
	@Test
	public void testBigInteger() {
		Integer i = new Integer(2147483647);
		System.out.println("i"+i);
		
		//Integer ii = new Integer("2147483648");
		//报错   java.lang.NumberFormatException，超出Integer范围
		
		BigInteger bi = new BigInteger("2147483648");
		System.out.println("bi:" + bi);
		
		BigInteger bi1 = new BigInteger("100");
		BigInteger bi2 = new BigInteger("20");
		
		System.out.println(bi1.add(bi2));
		System.out.println(bi1.subtract(bi2));
		System.out.println(bi1.multiply(bi2));
		System.out.println(bi1.divide(bi2));
		
		BigInteger[] ba = bi1.divideAndRemainder(bi2);
		System.out.println("商为"+ba[0]+"  余数为"+ba[1]);
	}
	
	@Test
	/**
	 *  * BigDecimal类：不可变的、任意精度的有符号十进制数,可以解决数据丢失问题。
	 */
	public void testBigDecimal() {
		System.out.println(0.09 + 0.01);
		System.out.println(1.0 - 0.32);
		System.out.println(1.015 * 100);
		System.out.println(1.301 / 100);

		System.out.println(1.0 - 0.12);
		
		BigDecimal bd1 = new BigDecimal("0.55");
		BigDecimal bd2 = new BigDecimal("0.5");
		
		System.out.println(bd1.add(bd2));
		System.out.println(bd1.subtract(bd2));
		System.out.println(bd1.multiply(bd2));
		System.out.println(bd1.divide(bd2));
		System.out.println(bd1.divide(bd2, 4, BigDecimal.ROUND_HALF_UP));
	}
}
