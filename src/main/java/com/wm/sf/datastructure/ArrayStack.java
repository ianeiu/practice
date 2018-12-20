package com.wm.sf.datastructure;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ArrayStack {
	private long[] a;
    private int size;   //栈数组的大小
    private int top;   //栈顶

    public ArrayStack(int maxSize){
        this.size = maxSize;
        this.a = new long[size];
        this.top = -1;   //表示空栈
    }

    public void push(long value){   //入栈
        if(isFull()){
            System.out.println("栈已满!");
            return;
        }
        a[++top] = value;
    }

    public long peek(){   //返回栈顶内容，但不删除
        if(isEmpty()){
            System.out.println("栈中没有数据");
            return 0;
        }
        return a[top];
    }


    public long pop(){   //弹出栈顶内容
        if(isEmpty()){
            System.out.println("栈中没有数据!");
            return 0;
        }
        return a[top--];
    }

    public int size(){
        return top + 1;
    }

    /**
     * 判断是否满了
     * @return
     */
    public boolean isFull(){
        return (top == size - 1);
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return (top == -1);
    }


    public void display(){
        for (int i = top; i >= 0; i--) {
            System.out.println(a[i] + " ");
        }
        System.out.println("");
    }
    
    
    public static void main(String[] args) {
		ArrayStack as = new ArrayStack(10);
		as.push(1L);
		as.push(30L);
		as.push(5L);
		as.display();
		as.pop();
		as.display();
		
		org.apache.commons.collections.ArrayStack ass = new org.apache.commons.collections.ArrayStack();
		ass.push("xixi");
		ass.push("long");
		ass.push(111);
		System.out.println(ass.stream().collect(Collectors.toList()));
		ass.pop();
		System.out.println(ass.stream().collect(Collectors.toList()));
	}
}
