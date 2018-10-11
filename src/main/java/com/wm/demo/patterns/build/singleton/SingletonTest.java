package com.wm.demo.patterns.build.singleton;

/**
 * 在系统内存中只存在一个对象，因此可以节约系统资源，对于一些需要频繁创建和销毁的对象单例模式无疑可以提高系统的性能。
 */
public class SingletonTest {
	class MyThreadEnum extends Thread {  
        @Override  
        public void run() {  
            for (int i = 0; i < 5; i++) {  
                System.out.println(SingletonEnum.getInstance().hashCode());  
            }  
        }  
    }  
	class MyThread1 extends Thread {  
		@Override  
		public void run() {  
			for (int i = 0; i < 11111; i++) {  
				System.out.println(Singleton.getInstance().hashCode());  
			}  
		}  
	}  
	class MyThread2 extends Thread {  
		@Override  
		public void run() {  
			for (int i = 0; i < 5; i++) {  
				System.out.println(Singleton2.getInstance().hashCode());  
			}  
		}  
	}  
	class MyThread3 extends Thread {  
		@Override  
		public void run() {  
			for (int i = 0; i < 5; i++) {  
				System.out.println(Singleton3.getInstance().hashCode());  
			}  
		}  
	}  
    public static void main(String[] args) {  
    	

    	System.out.println("");
    	System.out.println("MyThread1");
    	SingletonTest.MyThread1 t1 = new SingletonTest().new MyThread1();  
    	SingletonTest.MyThread1 t2 = new SingletonTest().new MyThread1();  
    	SingletonTest.MyThread1 t3 = new SingletonTest().new MyThread1();  
    	
    	t1.start();  
    	t2.start();  
    	t3.start(); 
    	
    	/*System.out.println("");
    	System.out.println("MyThreadEnum");
    	SingletonTest.MyThreadEnum e1 = new SingletonTest().new MyThreadEnum();  
    	SingletonTest.MyThreadEnum e2 = new SingletonTest().new MyThreadEnum();  
    	SingletonTest.MyThreadEnum e3 = new SingletonTest().new MyThreadEnum();  
  
        e1.start();  
        e2.start();  
        e3.start();  */
  
    } 
}
