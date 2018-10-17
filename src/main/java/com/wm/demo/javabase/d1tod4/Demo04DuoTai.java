package com.wm.demo.javabase.d1tod4;

class Fu {
	public int num = 100;
	
	public Fu() {
		super();
		System.out.println("new Fu");
	}

	public void show() {
		System.out.println("show Fu");
	}
	
	public static void function() {
		System.out.println("function Fu");
	}
}

class Zi extends Fu {
	public int num = 1000;
	public int num2 = 200;

	public Zi() {
		super();
		System.out.println("new Zi");
	}

	@Override
	public void show() {
		System.out.println("show Zi");
	}
	
	public void method() {
		System.out.println("method zi");
	}
	
	public static void function() {
		System.out.println("function Zi");
	}
}

class Demo04DuoTai {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		//父类引用指向子类对象  父 f =  new 子();
		Fu f = new Zi();
		System.out.println(f.num);
		//找不到符号
		//System.out.println(f.num2);
		
		f.show();
		//找不到符号
		//f.method();
		f.function();
		
		/*new Fu
		new Zi
		100
		show Zi
		function Fu*/
	}
}