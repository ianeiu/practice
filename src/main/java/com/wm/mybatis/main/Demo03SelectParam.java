package com.wm.mybatis.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.wm.mybatis.mapper.UserMapper;
import com.wm.mybatis.model.TbSysUser;

public class Demo03SelectParam {
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	

	@Test
	public void testResultMap() throws IOException{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession openSession = ssf.openSession();
		try{
			UserMapper mapper = openSession.getMapper(UserMapper.class);
			Map<String, TbSysUser> map = mapper.getUserMapByUserName("测试%");
			//{测试人员=TbSysUser(userId=test, userName=测试人员, passwork=null, userSex=2, createTime=Thu May 24 11:09:45 SGT 2018, status=false, depId=null), 
			//测试人员2=TbSysUser(userId=test2, userName=测试人员2, passwork=null, userSex=2, createTime=Wed Sep 12 14:27:57 SGT 2018, status=false, depId=null)}
			System.out.println(map);
			
			Map<String,Object> map2 = mapper.getUserMapByUserId("admin");
			//{user_sex=0, create_time=2018-05-24 11:09:28.0, user_id=admin, user_name=系统管理员, status=0}
			System.out.println(map2);
			
			List<TbSysUser> list = mapper.getUserListByUserName("测试%");
			//[TbSysUser(userId=test, userName=测试人员, passwork=null, userSex=2, createTime=Thu May 24 11:09:45 SGT 2018, status=false, depId=null),
			//TbSysUser(userId=test2, userName=测试人员2, passwork=null, userSex=2, createTime=Wed Sep 12 14:27:57 SGT 2018, status=false, depId=null)]
			System.out.println(list);
		}finally{
			openSession.close();
		}
	}
	
	@Test
	public void testParam() throws IOException{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession openSession = ssf.openSession();
		try{
			UserMapper mapper = openSession.getMapper(UserMapper.class);
			Map<String,Object> map = new HashMap<>();
			map.put("userId", "admin");
			map.put("userName", "系统%");
			TbSysUser user = mapper.getUserByMap(map);
			System.out.println(user);
			
			TbSysUser user2 = mapper.getUserByIdAndName("admin",  "系统%");
			System.out.println(user2);
			
			TbSysUser user3 = mapper.getUserAnnoationByIdAndName("admin",  "系统%");
			System.out.println(user3);
		}finally{
			openSession.close();
		}
	}
	
}
