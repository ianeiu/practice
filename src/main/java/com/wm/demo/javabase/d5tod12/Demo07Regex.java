package com.wm.demo.javabase.d5tod12;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo07Regex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 System.out.println("请输入手机号进行校验：");
		 String s = sc.nextLine();
		 String regex = "1[3578]\\d{9}";
		 System.out.println(s.matches(regex));
		
		 System.out.println("请输入邮箱进行校验：");
		 String s2 = sc.nextLine();
		 String regex2 = "\\w+@\\w{2,6}(\\.\\w{2,3})+";
		 System.out.println(s2.matches(regex2));
		System.out.println("-------------正则表达式基础结束-----------------");
		//对字符串排序输出
		String ss = "87 65 85 1 20 111 66";
		System.out.println(ss);
		String[] as = ss.split(" +");
		int[] i = new int[as.length];
		StringBuilder sb = new StringBuilder();
		String sss;
		
		for (int x = 0; x < as.length; x++) {
			i[x] = Integer.parseInt(as[x]);
		}
		Arrays.sort(i);
		for(int x = 0; x<i.length; x++){
			sb.append(i[x]+" ");
		}
		sss = sb.toString().trim();
		System.out.println(sss);
		System.out.println("------------String的regex分割功能结束------------------");
		
		String  th = "adasdac4647fa9df4adcasd";
		String thh = th.replaceAll("\\d", "数");
		System.out.println(thh);
		String thh2 = th.replaceAll("\\d+", "数");
		System.out.println(thh2);
		System.out.println("--------------String的regex替换功能结束----------------");
		
		String sbz = "da jia ting wo shuo,jin tian yao xia yu,bu shang wan zi xi,gao xing bu?";
		String regex3 = "\\b\\w{3}\\b";
		Pattern p = Pattern.compile(regex3);// 把规则编译成模式对象
		Matcher m = p.matcher(sbz);// 通过模式对象得到匹配器对象
		//先find()，后group()
		for(;m.find();){	// 通过find方法就是查找有没有满足条件的子串
			System.out.println(m.group());	// 通过group方法就是得到满足条件的子串
		}
		System.out.println("--------------Pattern和Matcher类的使用----------------");
	}
}
