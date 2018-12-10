package com.wm.demo.mybatis.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.wm.demo.mybatis.mapper.UserMapper;
import com.wm.demo.mybatis.model.OraclePage;
import com.wm.demo.mybatis.model.TbSysUser;

public class Demo08BatchCallEnum {
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-demo/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testBatch() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//可执行批量操作的sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
		
		long start = System.currentTimeMillis();
		try{
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			for (int i = 0; i < 10000; i++) {
				mapper.addUser(new TbSysUser(UUID.randomUUID().toString(),"test-m"+i));
			}
			sqlSession.commit();
			long end = System.currentTimeMillis();
			//批量：（预编译sql一次==>设置参数===>10000次===>执行（1次））
			//Parameters: 616c1(String), b(String), 1(String)==>4598
			//非批量：（预编译sql=设置参数=执行）==》10000    10200
			System.out.println("执行时长："+(end-start));
		}finally{
			sqlSession.close();
		}
	}
	
	/**
	 * oracle分页：
	 * 		借助rownum：行号；子查询；
	 * 存储过程包装分页逻辑
	 * @throws IOException 
	 */
	@Test
	public void testProcedure() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			OraclePage<TbSysUser> page = new OraclePage<>();
			page.setStart(1);
			page.setEnd(3);
			mapper.getUserPageByProcedure(page);
			
			System.out.println("总记录数："+page.getCount());
			System.out.println("查出的数据："+page.getUsers().size());
			System.out.println("查出的数据："+page.getUsers());
		}finally{
			sqlSession.close();
		}
	}
	
	/**
	 * 默认mybatis在处理枚举对象的时候保存的是枚举的名字：EnumTypeHandler
	 * 改变使用：EnumOrdinalTypeHandler：
	 * @throws IOException
	 */
	@Test
	public void testEnum() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			TbSysUser user = new TbSysUser("test_test", "ianeiu");
			mapper.addUser(user);
			System.out.println("保存成功"+user.getUserId());
			sqlSession.commit();
			TbSysUser userResult = mapper.getUserById("test_test");
			System.out.println(userResult.getStatus());
		}finally{
			sqlSession.close();
		}
	}
	
}
