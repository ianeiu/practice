package com.wm.demo.learn.java8.functionIterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.junit.Test;

/**
 * 函数式接口
 * @author wm
 *
 */
public class Java8Tester {
   public static void main(String args[]){
      List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        
      // Predicate<Integer> predicate = n -> true
      // n 是一个参数传递到 Predicate 接口的 test 方法
      // n 如果存在则 test 方法返回 true
        
      System.out.println("输出所有数据:");
        
      // 传递参数 n
      eval(list, n->true);
      System.out.println("=================================================");
        
      // Predicate<Integer> predicate1 = n -> n%2 == 0
      // n 是一个参数传递到 Predicate 接口的 test 方法
      // 如果 n%2 为 0 test 方法返回 true
        
      System.out.println("输出所有偶数:");
      eval(list, n-> n%2 == 0 );
      System.out.println("=================================================");
        
      // Predicate<Integer> predicate2 = n -> n > 3
      // n 是一个参数传递到 Predicate 接口的 test 方法
      // 如果 n 大于 3 test 方法返回 true
        
      System.out.println("输出大于 3 的所有数字:");
      eval(list, n-> n > 3 );
      System.out.println("=================================================");
   }
    
   public static void eval(List<Integer> list, Predicate<Integer> predicate) {
      for(Integer n: list) {
         if(predicate.test(n)) {
            System.out.println(n + " ");
         }
      }
      Predicate<Integer> p = predicate.and(t->t<5);
      Predicate<Integer> p2 = predicate.or(t->t==9);
      System.out.println("且小于5");
      for(Integer n: list) {
          if(p.test(n)) {
             System.out.println(n + " ");
          }
       }
      System.out.println("或等于9");
      for(Integer n: list) {
    	  if(p2.test(n)) {
    		  System.out.println(n + " ");
    	  }
      }
   }
   
   
   public static void eval3(UnaryOperator<String> uo,String s){
	   System.out.println(uo.apply(s));
   }
   
   @Test
   public void testEval3(){
	   String s = "hehe";
	   eval3(p->p+"aa",s);
   }
}