package com.wm.demo.mybatis.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.wm.demo.mybatis.mapper.UserDynamicMapper;
import com.wm.demo.mybatis.model.TbSysUser;

public class Demo05DynamicSQL {

	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-demo/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testDynamicSql() throws IOException{
		SqlSessionFactory ssf = this.getSqlSessionFactory();
		SqlSession sqlSession = ssf.openSession();
		
		try{
			UserDynamicMapper mapper = sqlSession.getMapper(UserDynamicMapper.class);
			TbSysUser user = new TbSysUser();
			//user.setUserId("admin");
			user.setUserName("测试%");
			
			//condition if
			//System.out.println(mapper.getUsersByConditionIf(user));
			
			//condition trim
			//System.out.println(mapper.getUsersByConditionTrim(user));
			
			//condition choose
			//System.out.println(mapper.getUsersByConditionChoose(user));
			
			//update set
			/*user.setUserId("test2");
			user.setUserName("测试2");
			mapper.updateUser(user);
			sqlSession.commit();*/
			
			//condition foreach
			/*List<String> ids = Arrays.asList("admin","test");
			System.out.println(mapper.getUsersByConditionForeach(ids));*/

			//deal param
			/*user.setUserName("测试");
			System.out.println(mapper.getUsersDealParam(user));*/
			
			//addUsers
			TbSysUser user1 = new TbSysUser()
					.setUserId("test3")
					.setUserName("测试人员3")
					.setUserSex(0)
					.setCreateTime(new Date());
			TbSysUser user2 = new TbSysUser()
					.setUserId("test4")
					.setUserName("测试人员5")
					.setUserSex(1)
					.setCreateTime(new Date());
			List<TbSysUser> users = new ArrayList<>();
			users.add(user1);
			users.add(user2);
			mapper.addUsers(users);
			sqlSession.commit();
			
		}finally {
			sqlSession.close();
		}
		
	}
	
}
