package com.wm.demo.javabase.annotation;

import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //ApiAuthDataInit
public class Demo01{

	public static void main(String[] args) {
		
		Class<?> clz = Test.class;
		Method[] methods = clz.getMethods();
		for (Method method : methods) {
		    if (method.isAnnotationPresent(EnableAuth.class)) {
		        String name = method.getAnnotation(EnableAuth.class).name();
		        System.out.println(name);
		    }
		}
		//test();
	}
	
	
	@Deprecated
	@RequestMapping
	@EnableAuth
	public static String test(){
		return "";
	}
}	

class Test{
	
	@EnableAuth
	public String test(){
		return "";
	}
}
