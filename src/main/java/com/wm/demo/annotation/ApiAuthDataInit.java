package com.wm.demo.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class ApiAuthDataInit implements ApplicationContextAware {

	public static List<String> checkApis = new ArrayList<String>();

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		Map<String, Object> beanMap = ctx.getBeansWithAnnotation(RestController.class);
		if (beanMap != null) {
			for (Object bean : beanMap.values()) {
				Class<?> clz = bean.getClass();
				Method[] methods = clz.getMethods();
				for (Method method : methods) {
					if (method.isAnnotationPresent(EnableAuth.class)) {
						String uri = getApiUri(clz, method);
						checkApis.add(uri);
					}
				}
			}
		}
		System.out.println(checkApis);
	}

	private String getApiUri(Class<?> clz, Method method) {
		StringBuilder uri = new StringBuilder();
		uri.append(clz.getAnnotation(RequestMapping.class).value()[0]);
		if (method.isAnnotationPresent(RequestMapping.class)) {
			uri.append(method.getAnnotation(RequestMapping.class).value()[0]);
		}else if (method.isAnnotationPresent(RequestMapping.class)) {
			uri.append(method.getAnnotation(EnableAuth.class).name());
		}
		return uri.toString();
	}

}
