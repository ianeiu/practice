package com.wm.demo.writeexam;

public class StringDD {
	/**
	 * 一些基本类型的变量和对象的引用变量都是在函数的栈内存中分配，而堆内存中则存放new 出来的对象和数组。然而除此之外还有一块区域叫做常量池。
像我们通常想String s1 = "hello"; 这样申明的字符串对象，其值就是存储在常量池中。
当我们创建String s1 = "hello"这样一个对象之后，"hello"就存储到了常量池（也可叫做字符串池）中，当我们创建引用String s2  = "hello" 的时候，
Java底层会优先在常量池中查找是否存在"hello"，如果存在则让s2指向这个值，不会重新创建，如果常量池中没有则创建并添加的池中。这就是为什么答案是true 和false的原因。
	*/
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");
		
		//都存储在常量池中,指向同一常量
		System.out.println(s1==s2); // true
		//存储在常量池中,存储在堆内存中
		System.out.println(s1==s3); // false
		
		String s4 = "helloo";
		/**
		 * 会重新在常量池创建常量（String不可变属性）
		 */
		String s5 = s1+"o";
		//字符串拼接有变量参与，底层调用StringBuffer处理，相当于在堆内存中开辟了新空间
		System.out.println(s4 == s5); // false
		//常量相加，先在常量池找，找到即用
		System.out.println(s4 == "hello"+"o");//true

		//hello
		String s6 = s4.substring(0, s4.length() - 1);
		//substring返回的也是new出来的String对象
		System.out.println(s1 == s6); // false
		System.out.println(s3 == s6); // false
	}
}
