package com.wm.demo.mybatis.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.wm.demo.mybatis.mapper.UserAnnotationMapper;
import com.wm.demo.mybatis.mapper.UserMapper;
import com.wm.demo.mybatis.model.TbSysUser;

/**
 * 1、接口式编程
 * 	原生：		Dao		====>  DaoImpl
 * 	mybatis：	Mapper	====>  xxMapper.xml
 * 
 * 2、SqlSession代表和数据库的一次会话；用完必须关闭；
 * 3、SqlSession和connection一样她都是非线程安全。每次使用都应该去获取新的对象。
 * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。
 * 		（将接口和xml进行绑定）
 * 		UserMapper user = sqlSession.getMapper(UserMapper.class);
 * 5、两个重要的配置文件：
 * 		mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等...系统运行环境信息
 * 		sql映射文件：保存了每一个sql语句的映射信息：
 * 					将sql抽取出来。	
 * @author WM
 *
 */
public class Demo01Base {
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-demo/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/**
	 * 方式1
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {

		SqlSessionFactory ssf = this.getSqlSessionFactory();

		SqlSession openSession = ssf.openSession();
		try {
			TbSysUser user = openSession.selectOne( 
					"com.wm.demo.mybatis.mapper.UserMapper.getUserById", "admin");
			System.out.println(user);
		} finally {
			openSession.close();
		}

	}
	
	/**
	 * 方式2
	 * @throws IOException
	 */
	@Test
	public void test01() throws IOException {
		// 1、获取sqlSessionFactory对象
		SqlSessionFactory ssf = this.getSqlSessionFactory();
		// 2、获取sqlSession对象
		SqlSession openSession = ssf.openSession();
		try {
			// 3、获取接口的实现类对象
			//会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
			UserMapper mapper = openSession.getMapper(UserMapper.class);
			TbSysUser user = mapper.getUserById("admin");
			System.out.println(mapper.getClass());
			System.out.println(user);
		} finally {
			openSession.close();
		}

	}
	
	/**
	 * 方式3 注解
	 * @throws IOException
	 */
	@Test
	public void test02() throws IOException {
		SqlSessionFactory ssf = this.getSqlSessionFactory();
		SqlSession openSession = ssf.openSession();
		try {
			UserAnnotationMapper mapper = openSession.getMapper(UserAnnotationMapper.class);
			TbSysUser user = mapper.getUserById("admin");
			System.out.println(user);
		} finally {
			openSession.close();
		}
	}
}
