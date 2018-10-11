package com.wm.demo.writeexam;

/**
 * 严格来说，Java中只有值传递。基本数据类型作为形参传递就是值传递，而引用类型作为形参传递就是地址值传递
 */

class IntDemo{
	int i;
	public IntDemo(int i){
		this.i = i;
	}
}

public class Quote {
	
	public static void main(String[] args) {
		IntDemo id1 = new IntDemo(1);
		IntDemo id2 = new IntDemo(2);

		System.out.println(id1+" "+id2);
		System.out.printf("id1 = %s,id2 = %s \n",id1.i,id2.i);
		System.out.println("------------------------------------");
		function(id1,id2);
		System.out.printf("id1 = %s,id2 = %s \n",id1.i,id2.i);
		System.out.println("------------------------------------");
		function2(id1,id2);
		System.out.printf("id1 = %s,id2 = %s \n",id1.i,id2.i);
		System.out.println("------------------------------------");
		function3(id1,id2);
		System.out.printf("id1 = %s,id2 = %s \n",id1.i,id2.i);
	}

	private static void function(IntDemo id1, IntDemo id2) {
		IntDemo idtemp = id1;
		id1 = id2;
		id2 = idtemp;
		System.out.println(id1+" "+id2);
	}

	private static void function2(IntDemo id1, IntDemo id2) {
		int temp = id1.i;
		id1 = new IntDemo(id2.i);
		id2 = new IntDemo(temp);
		System.out.println(id1+" "+id2);
	}

	/**
	 * function3()函数内改变的并不是id1和id2本身的值，而是id1和id2指向的对象的值，
	 * 调用完function3()后id1和id2仍然指向函数调用前的堆地址，即函数参数是栈中的id1和id2，而不是堆中id1和id2指向的对象，
	 * 即使你在函数中改变了堆中的对象，但没有改变函数参数的值
	 * 
	 * 直接操作形参所指向的对象实际地址，无论是实参还是其他地方，只要是指向该对象的所有的引用地址对应的值都会改变
	 */
	private static void function3(IntDemo id1, IntDemo id2) {
		int temp = id1.i;
		id1.i = id2.i;
		id2.i = temp;
		System.out.println(id1+" "+id2);
	}
	
	
}
