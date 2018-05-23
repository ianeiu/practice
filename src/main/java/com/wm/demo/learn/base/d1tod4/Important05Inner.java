package com.wm.demo.learn.base.d1tod4;

/**
 * 按照要求，补齐代码
	interface Inter { void show(); }
	class Outer { //补齐代码 }
	class OuterDemo {
	    public static void main(String[] args) {
		      Outer.method().show();
		  }
	}
要求在控制台输出”HelloWorld”
 * @author WM
 *
 */
interface Inter { void show(); }
class Outer { 
	public static Inter method() {
		return new Inter () {
			public void show() {
				System.out.println("Hello world");
			}
		};
	}

}



public class Important05Inner {
	public static void main(String[] args) {
	      Outer.method().show();
	  }
}
