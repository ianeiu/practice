package com.wm.demo.jedis;

import redis.clients.jedis.Jedis;

public class Demo01Connect {
	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("192.168.136.72",6379);
		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
	}
}
