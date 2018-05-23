package com.wm.demo.patterns.strut.proxy;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void testProxy(){
		/**
		 * 创建PersonDaoImpl对象
		 * 创建事务对象
		 * 创建PersonDaoProxy对象
		 */
		PersonDao personDao = new PersonDaoImpl();
		Transaction transaction = new Transaction();
		PersonDaoProxy personDaoProxy = new PersonDaoProxy(personDao, transaction);
		personDaoProxy.savePerson();
	}
}
