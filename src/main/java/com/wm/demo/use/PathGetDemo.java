package com.wm.demo.use;

import java.io.File;

public class PathGetDemo {
	public static void main(String[] args) {

		//	file:/E:/EclipseBuilder/j-util/target/classes/
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("")); 
        System.out.println(PathGetDemo.class.getClassLoader().getResource("")); 
        System.out.println(ClassLoader.getSystemResource("")); 
        System.out.println(PathGetDemo.class.getResource("/"));
        
        //	file:/E:/EclipseBuilder/j-util/target/classes/com/wm/demo/use/
        System.out.println(PathGetDemo.class.getResource(""));
        //	file:/E:/EclipseBuilder/j-util/target/classes/com/wm/demo/use/test.xml
        System.out.println(PathGetDemo.class.getResource("test.xml"));
        
        //	E:\
        System.out.println(new File("/").getAbsolutePath()); 
        
        //	E:\EclipseBuilder\j-uti
        System.out.println(System.getProperty("user.dir")); 
        
        //	/E:/EclipseBuilder/j-util/target/classes/com/wm/demo/use/test.xml
		System.out.println(PathGetDemo.class.getResource("test.xml").getPath());
		System.out.println(PathGetDemo.class.getResource("").getPath()+"test.xml");
	}
}
