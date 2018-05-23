package com.wm.demo.patterns.strut.proxy;

public class PersonDaoProxy implements PersonDao{
	private PersonDao personDao;
	private Transaction transaction;
	public PersonDaoProxy(PersonDao personDao,Transaction transaction){
		this.personDao = personDao;
		this.transaction = transaction;
	}
	public void savePerson() {
		/**
		 * 1、开启事务
		 * 2、进行save操作
		 * 3、事务提交
		 */
		this.transaction.beginTransaction();
		this.personDao.savePerson();
		this.transaction.commit();
	}
}
