package com.wm.demo.mybatis.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.wm.demo.mybatis.mapper.UserMapper;
import com.wm.demo.mybatis.model.TbSysUser;

public class Demo02CUD {
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-demo/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/**
	 * 增
	 * @throws IOException
	 */
	@Test
	public void testC() throws IOException {
		SqlSessionFactory ssf = this.getSqlSessionFactory();
		//1、获取到的SqlSession不会自动提交数据
		SqlSession openSession = ssf.openSession();
		
		try{
			UserMapper mapper = openSession.getMapper(UserMapper.class);
			//测试添加
			TbSysUser user = new TbSysUser();
			user.setUserId("test1");
			user.setPasswork("123");
			user.setStatus(true);
			user.setUserName("测试");
			user.setUserSex(1);
			System.out.println(mapper.addUser(user));
			//2、手动提交数据
			openSession.commit();
		}finally{
			openSession.close();
		}
	}
	
	/**
	 * 改
	 * @throws IOException
	 */
	@Test
	public void testU() throws IOException {
		SqlSessionFactory ssf = this.getSqlSessionFactory();
		//1、获取到的SqlSession不会自动提交数据
		SqlSession openSession = ssf.openSession();
		
		try{
			UserMapper mapper = openSession.getMapper(UserMapper.class);
			//测试修改
			TbSysUser user = new TbSysUser();
			user.setUserId("admin");
			user.setPasswork("123");
			System.out.println(mapper.updateUser(user));
			//2、手动提交数据
			openSession.commit();
		}finally{
			openSession.close();
		}
	}
	/**
	 * 删
	 * @throws IOException
	 */
	@Test
	public void testD() throws IOException {
		SqlSessionFactory ssf = this.getSqlSessionFactory();
		//1、获取到的SqlSession不会自动提交数据
		SqlSession openSession = ssf.openSession();
		
		try{
			UserMapper mapper = openSession.getMapper(UserMapper.class);
			//测试删除
			mapper.deleteUserById("test");
			//2、手动提交数据
			openSession.commit();
		}finally{
			openSession.close();
		}
	}
	
	
}
