package com.wm.demo.patterns.strut.proxy;

public class Transaction {

	public void beginTransaction() {
		System.out.println("begin-transaction");
	}
	
	public void commit() {
		System.out.println("commit");
	}
}
