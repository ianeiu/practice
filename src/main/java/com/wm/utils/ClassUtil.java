package com.wm.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类操作工具类
 * @author FengHuayuan
 * @date 2018年2月4日 下午4:29:56.
 */
public final class ClassUtil {

	//private static Log log = LogFactory.getLog(ClassUtil.class);
	/**
	 * 使用springboot自带的logback
	 * wm add  2018.07.12
	 */
	private static final Logger log = LoggerFactory.getLogger(ClassUtil.class);

	private ClassUtil() {

	}
	
	public static class EntryKeyValue {
		private String key;
		private Object value;

		private EntryKeyValue(String key, Object value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public boolean equals(Object value) {
			if (value == null) {
				throw new RuntimeException("值不能为空！");
			}
			return value.equals(this.value);
		}

		public static EntryKeyValue map(String key, Object value) {
			return new EntryKeyValue(key, value);
		}

	}

	public static Object readFieldValue(String propertyKey, Object obj) {
		try {
			if (StringUtils.isBlank(propertyKey))
				return null;
			else if (obj == null)
				return null;
			PropertyDescriptor pd = new PropertyDescriptor(propertyKey, obj.getClass());
			Method readMethod = pd.getReadMethod();
			return readMethod.invoke(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean writeFieldValue(String propertyKey, Object propertyValue, Object obj) {
		return writeFieldValue(propertyKey, propertyValue, obj, false);
	}

	public static boolean writeFieldValue(String propertyKey, Object propertyValue, Object obj, boolean skipErr) {
		Class<?> clazz = obj.getClass();
		do {
			try {
				PropertyDescriptor pd = new PropertyDescriptor(propertyKey, clazz);
				Method writeMethod = pd.getWriteMethod();
				if (propertyValue != null) {
					if (writeMethod.getParameterTypes()[0] == Boolean.class) {
						if ("0".equals(propertyValue.toString())) {
							writeMethod.invoke(obj, Boolean.FALSE);
						} else if ("1".equals(propertyValue.toString())) {
							writeMethod.invoke(obj, Boolean.TRUE);
						}
					} else if (writeMethod.getParameterTypes()[0] == Integer.class) {
						writeMethod.invoke(obj, Integer.valueOf(propertyValue.toString()));
					} else if (writeMethod.getParameterTypes()[0] == Long.class) {
						writeMethod.invoke(obj, Long.valueOf(propertyValue.toString()));
					} else {
						writeMethod.invoke(obj, propertyValue);
					}
				}
				return true;
			} catch (IntrospectionException e) {
				continue;
			} catch (Exception e) {
				if (!skipErr) {
					throw new RuntimeException(e);
				}
				return false;
			}
		} while ((clazz = clazz.getSuperclass()) != null);
		return false;
	}

	public static boolean checkNull(String propertyKey, Object obj) {
		Object value = readFieldValue(propertyKey, obj);
		if (value instanceof String) {
			return value == null || "".equals(((String) value).trim());
		}
		return value == null;
	}

	public static <T> T construct(Class<T> clazz, EntryKeyValue... entryKeyValues) {
		try {
			Constructor<T> constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			T obj = constructor.newInstance();
			if (entryKeyValues != null) {
				for (EntryKeyValue entryKeyValue : entryKeyValues) {
					writeFieldValue(entryKeyValue.getKey(), entryKeyValue.getValue(), obj);
				}
			}
			return obj;
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("[" + clazz.getName() + "]类没有默认构造方法!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Type[] getActualTypeArguments(Class<?> childClass) {
		return ((ParameterizedType) childClass.getGenericSuperclass()).getActualTypeArguments();
	}

	/**
	 * 判断该名字的对象属性是否含有注解(注意:不包含父类属性)
	 * @author FengHuayuan
	 * @date 2018年2月25日 下午1:42:54.
	 * @param obj
	 * @param name
	 * @param annotationClass
	 * @return
	 */
	public static boolean isFieldAnnotationPresent(Object obj, String name,
			Class<? extends Annotation> annotationClass) {
		if (obj == null) {
			throw new RuntimeException("传入的对象为空!");
		}
		try {
			Field field = obj.getClass().getDeclaredField(name);
			return field.isAnnotationPresent(annotationClass);
		} catch (NoSuchFieldException e) {
			if (log.isDebugEnabled()) {
				log.debug("类[" + obj.getClass() + "]没有包含" + name + "属性!");
			}
			return false;
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获得包下面的所有的class
	 * @author FengHuayuan
	 * @date 2018年4月21日 下午12:25:20.
	 * @param pack
	 * @return
	 */
	public static List<Class<?>> getClassesFromPackage(String pack) {
		List<Class<?>> clazzs = new ArrayList<Class<?>>();
		// 是否循环搜索子包
		boolean recursive = true;
		// 包名字
		String packageName = pack;
		// 包名对应的路径名称
		String packageDirName = packageName.replace('.', '/');
		Enumeration<URL> dirs;
		try {
			dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
			while (dirs.hasMoreElements()) {
				URL url = dirs.nextElement();
				String protocol = url.getProtocol();
				if ("file".equals(protocol)) {
					log.debug("*****【File类型】的扫描！");
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					findClassInPackageByFile(packageName, filePath, recursive, clazzs);
				} else if ("jar".equals(protocol)) {
					log.debug("*****【Jar类型】的扫描！");
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					getClasssFromJarFile(filePath, clazzs);
				}
			}

		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return clazzs;
	}

	/**
	 * 在package对应的路径下找到所有的class
	 * @author FengHuayuan
	 * @date 2018年4月21日 下午12:24:54.
	 * @param packageName
	 * @param filePath
	 * @param recursive
	 * @param clazzs
	 */
	public static void findClassInPackageByFile(String packageName, String filePath, final boolean recursive,
			List<Class<?>> clazzs) {
		File dir = new File(filePath);
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}
		// 在给定的目录下找到所有的文件，并且进行条件过滤
		File[] dirFiles = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File file) {
				boolean acceptDir = recursive && file.isDirectory();// 接受dir目录
				boolean acceptClass = file.getName().endsWith("class");// 接受class文件
				return acceptDir || acceptClass;
			}
		});
		for (File file : dirFiles) {
			if (file.isDirectory()) {
				findClassInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, clazzs);
			} else {
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					clazzs.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/** 
	 * 从jar文件中读取指定目录下面的所有的class文件 
	 * springboot打jar包专用
	 * @author wm
	 * @param jarPaht   jar文件存放的位置 
	 * @param filePaht    指定的文件目录 
	 * @param clazzs 所有的的class的对象 
	 */  
	public static void getClasssFromJarFile(String jarPath,List<Class<?>> clazzs) {  

		log.info("getClasssFromJarFile - jarPath:"+jarPath);//wm
		//jarPaht:file:/E:/IDEABuilder/fs/tyrz-springboot/tyrz-front/target/fsrzfw.jar!/BOOT-INF/classes!/cn/com/do1/component/identitySource/service/impl
		String[] jarPaths = jarPath.split("!");
		String jarPaht=jarPaths[0].substring(6);//去掉file:/
		String startDir = (jarPaths[1]+jarPaths[2]).substring(1);//去掉/
		
	    JarFile jarFile = null;  
	    try {  
	        jarFile = new JarFile(jarPaht);  
	    } catch (IOException e1) {  
	        e1.printStackTrace();  
	    }  
	  
	    List<JarEntry> jarEntryList = new ArrayList<JarEntry>();  
	  
	    Enumeration<JarEntry> ee = jarFile.entries();  
	    while (ee.hasMoreElements()) {  
	        JarEntry entry = (JarEntry) ee.nextElement();  
	        if (entry.getName().startsWith(startDir) && entry.getName().endsWith(".class")) {  
		        log.info("getClasssFromJarFile - entry:"+entry.getName());//wm
	            jarEntryList.add(entry);  
	        }  
	    }  
	    for (JarEntry entry : jarEntryList) {  
	        String className = entry.getName().replace('/', '.');  
			//   BOOT-INF/classes/cn/com/do1/component/identitySource/service/impl/XXX.class
	        className = className.substring(17, className.length() - 6);//去掉  BOOT-INF/classes/     .class
	        try {  
	            clazzs.add(Thread.currentThread().getContextClassLoader().loadClass(className));  
	        } catch (ClassNotFoundException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  
	}

}
