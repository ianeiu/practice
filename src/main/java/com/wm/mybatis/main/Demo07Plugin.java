package com.wm.mybatis.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wm.mybatis.mapper.UserMapper;
import com.wm.mybatis.model.TbSysUser;

public class Demo07Plugin {

	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	

	/**
	 * 插件编写：
	 * 1、编写Interceptor的实现类
	 * 2、使用@Intercepts注解完成插件签名
	 * 3、将写好的插件注册到全局配置文件中
	 */
	@Test
	public void test() throws IOException {

		SqlSessionFactory ssf = this.getSqlSessionFactory();

		SqlSession openSession = ssf.openSession();
		try {
			TbSysUser user = openSession.selectOne( 
					"UserMapper.getUserById", "admin");
			System.out.println(user);
		} finally {
			openSession.close();
		}

	}
	
	@Test
	public void testPagePlugin() throws IOException{
		// 1、获取sqlSessionFactory对象
		SqlSessionFactory ssf = this.getSqlSessionFactory();
		// 2、获取sqlSession对象
		SqlSession openSession = ssf.openSession();
		try {
			// 3、获取接口的实现类对象
			//会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
			UserMapper mapper = openSession.getMapper(UserMapper.class);
			Page<Object> page = PageHelper.startPage(1,3);
		
			List<TbSysUser> users = mapper.getUserListByUserName("%测试%"); 
			PageInfo<TbSysUser> userPage = new PageInfo<>(users, 10);
			
			for(TbSysUser user:users){
				System.out.println(user);
			}
			
			System.out.println("当前页码："+page.getPageNum());
			System.out.println("总记录数："+page.getTotal());
			System.out.println("每页的记录数："+page.getPageSize());
			System.out.println("总页码："+page.getPages());
			System.out.println("------------------------");
			System.out.println("当前页码："+userPage.getPageNum());
			System.out.println("总记录数："+userPage.getTotal());
			System.out.println("每页的记录数："+userPage.getPageSize());
			System.out.println("总页码："+userPage.getPages());
			System.out.println("是否第一页："+userPage.isIsFirstPage());
			System.out.println("获取结果集："+userPage.getList());
			for (TbSysUser tbSysUser : userPage.getList()) {
				System.out.println(tbSysUser);
			}
			System.out.println("连续显示的页码：");
			int[] nums = userPage.getNavigatepageNums();
			for (int i = 0; i < nums.length; i++) {
				System.out.println(nums[i]);
			}
		} finally {
			openSession.close();
		}
		
	}
	
	
}
