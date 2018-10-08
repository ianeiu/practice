package com.wm.demo.patterns.strut.adapter;

import java.util.*;

/**
 * 目的是复用已有的功能
 * 
 * 优点:复用、扩展
 * 缺点:过多的使用适配器，系统会非常凌乱，不容易入手
 */
public class Client {
	public static void main(String[] args) {
		//准备日志内容，也就是测试的数据
		LogModel lm1 = new LogModel();
		lm1.setLogId("001");
		lm1.setOperateUser("admin");
		lm1.setOperateTime("2010-03-02 10:08:18");
		lm1.setLogContent("这是一个测试");
		
		List<LogModel> list = new ArrayList<LogModel>();
		list.add(lm1);

		//创建操作日志文件的对象
		LogFileOperateApi logFileApi = new LogFileOperate("");
		
		//创建新版的操作日志的接口对象
		LogDbOperateApi api = new MyAdapter(logFileApi,new TimeUtil()); 
		
//		LogDbOperateApi api = null;
		
		
		/////////////////////////真正的操作
		//保存日志文件
		api.createLog(lm1);
		
		//读取日志文件的内容
		List<LogModel> allLog = api.getAllLog();
		System.out.println("allLog44="+allLog);
	}
}
