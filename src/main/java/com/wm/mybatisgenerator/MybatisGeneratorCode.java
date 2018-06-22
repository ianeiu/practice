package com.wm.mybatisgenerator;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisGeneratorCode {

	public void generator() throws Exception{

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("src/main/java/com/wm/mybatisgenerator/mybatis-generator-config.xml"); //指定 逆向工程配置文件
		System.out.println("----------------------------1");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		System.out.println("----------------------------2");
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback, warnings);
		System.out.println("----------------------------3");
		myBatisGenerator.generate(null);
		System.out.println("----------------------------4");

	} 
	public static void main(String[] args){
		try {
			MybatisGeneratorCode generatorSqlmap = new MybatisGeneratorCode();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
