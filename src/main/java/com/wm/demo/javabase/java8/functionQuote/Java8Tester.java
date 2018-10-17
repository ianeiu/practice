package com.wm.demo.javabase.java8.functionQuote;

/**
 * 方法引用
 */
import java.util.ArrayList;
import java.util.List;
 
public class Java8Tester {
   public static void main(String args[]){
      List<String> names = new ArrayList<>();
        
      names.add("Google");
      names.add("Runoob");
      names.add("Taobao");
      names.add("Baidu");
      names.add("Sina");
        
      names.forEach(System.out::println);
   }
}
