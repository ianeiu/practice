package com.wm.sf.datastructure;

import java.util.Stack;

/**
 * 
 * 编写一个类，用两个栈实现队列，支持队列的基本操作(add、poll、peek)。
 *
 */
public class Problem02_TwoStacksImplementQueue {

    public static class myQueue{

        Stack<Integer> stackPush;
        Stack<Integer> stackPop;

        public myQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }
        
        /**
         * add只负责往stack1里面添加数据
         * @param newNum
         */
        public void add(Integer newNum){
            stackPush.push(newNum);
        }

        /**
         * 这里要注意两点：
         * 1.stack1要一次性压入stack2
         * 2.stack2不为空，stack1绝不能向stack2压入数据
         * @return
         */
        public Integer poll(){
            if(stackPush.isEmpty() && stackPop.isEmpty()){
                throw new RuntimeException("Queue is Empty");
            }else if(stackPop.isEmpty()){
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public Integer peek(){
            if(stackPush.isEmpty() && stackPop.isEmpty()){
                throw new RuntimeException("Queue is Empty");
            }else if(stackPop.isEmpty()){
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        myQueue mQueue = new myQueue();
        mQueue.add(1);
        mQueue.add(2);
        mQueue.add(3);
        System.out.println(mQueue.peek());
        System.out.println(mQueue.poll());
        System.out.println(mQueue.peek());
        System.out.println(mQueue.poll());
        System.out.println(mQueue.peek());
        System.out.println(mQueue.poll());

    }
}