package com.wm.demo.patterns.strut.proxy;

import org.junit.Test;

/**
 * 静态代理
 * 代理对象可以在客户端和目标对象之间起到中介的作用
 * 
 * 优点：给对象增加了本地化的扩展性，增加了存取操作控制
 * 缺点：会产生多余的代理类
 */
public class ClientProxy {
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
