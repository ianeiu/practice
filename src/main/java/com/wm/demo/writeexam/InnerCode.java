package com.wm.demo.writeexam;

/**
 * 按照要求，补齐代码
	interface Inter { void show(); }
	class Outer { //补齐代码 }
	class OuterDemo {
	    public static void main(String[] args) {
		      Outer.method().show();
		  }
	}
要求在控制台输出”Hello World”
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
class OuterDemo {
    public static void main(String[] args) {
	      Outer.method().show();
	  }
}



public class InnerCode {
	public static void main(String[] args) {
	      Outer.method().show();
	  }
}
