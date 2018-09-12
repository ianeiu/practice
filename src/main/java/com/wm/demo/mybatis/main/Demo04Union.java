package com.wm.demo.mybatis.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.wm.demo.mybatis.mapper.DepartmentMapper;
import com.wm.demo.mybatis.mapper.UserMapper;
import com.wm.demo.mybatis.mapper.UserUnionDepMapper;
import com.wm.demo.mybatis.model.TbSysDep;
import com.wm.demo.mybatis.model.TbSysUser;
import com.wm.demo.mybatis.model.TbSysUserVO;

public class Demo04Union {
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-demo/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//USER
	
	@Test
	public void testUnionSelect() throws IOException{
		SqlSessionFactory ssf = this.getSqlSessionFactory();
		SqlSession sqlSession = ssf.openSession();
		try{
			UserUnionDepMapper mapper = sqlSession.getMapper(UserUnionDepMapper.class);
			System.out.println(mapper.getUserByUserId("admin"));
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testUnionSelectByStep() throws IOException{
		SqlSessionFactory ssf = this.getSqlSessionFactory();
		SqlSession sqlSession = ssf.openSession();
		try{
			UserUnionDepMapper mapper = sqlSession.getMapper(UserUnionDepMapper.class);
			TbSysUserVO vo = mapper.getUserByUserIdStep("admin");
			System.out.println(vo.getUserId());
			System.out.println(vo.getDep());
		}finally{
			sqlSession.close();
		}
	}
	
	
	@Test
	public void testListSelectByDepId() throws IOException{
		SqlSessionFactory ssf = this.getSqlSessionFactory();
		SqlSession sqlSession = ssf.openSession();
		try{
			UserUnionDepMapper mapper = sqlSession.getMapper(UserUnionDepMapper.class);
			System.out.println(mapper.getUserListByDepId("2"));
		}finally{
			sqlSession.close();
		}
	}
	
	//DEP
	
	@Test
	public void testDepUnion() throws IOException{
		SqlSessionFactory ssf = this.getSqlSessionFactory();
		SqlSession sqlSession = ssf.openSession();
		try{
			DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
			System.out.println(mapper.getDepById("2"));
			System.out.println(mapper.getDepByIdPlus("2"));
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testDepUnionStep() throws IOException{
		SqlSessionFactory ssf = this.getSqlSessionFactory();
		SqlSession sqlSession = ssf.openSession();
		try{
			DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
			TbSysDep dep = mapper.getDepByIdStep("2");
			System.out.println(dep.getDepName());
			System.out.println(dep.getUserList());
		}finally{
			sqlSession.close();
		}
	}
	
}
