package com.wm.demo.mybatis.plugin;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * 完成插件签名： 告诉MyBatis当前插件用来拦截哪个对象的哪个方法
 * @Description: MyFirstPlugin
 * @author: wm
 * @date: 2018年12月10日 下午2:53:47
 * @version: 1.0
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "parameterize", args = java.sql.Statement.class) })
public class MyFirstPlugin  implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("MyFirstPlugin...intercept:"+invocation.getMethod());
		//动态改变sql运行的参数
		Object target = invocation.getTarget();
		System.out.println("当前拦截对象："+target);
		//拿到：StatementHandler => ParameterHandler => paramterObject
		MetaObject metaObject = SystemMetaObject.forObject(target);
		Object value = metaObject.getValue("parameterHandler.parameterObject");
		System.out.println("sql语句用的参数："+value);
		//修改完sql语句要用的参数
		metaObject.setValue("parameterHandler.parameterObject", "test");
		//执行目标方法
		Object proceed = invocation.proceed();
		//返回执行后的值
		return proceed;
	}

	@Override
	public Object plugin(Object target) {
		//我们可以借助Plugin的wrap方法来使用当前Interceptor包装我们目标对象
		System.out.println("MyFirstPlugin...plugin:mybatis将要包装的对象"+target);
		Object wrap = Plugin.wrap(target, this);
		//返回为当前target创建的动态代理
		return wrap;
	}

	@Override
	public void setProperties(Properties properties) {
		System.out.println("插件配置的信息："+properties);
	}

}
