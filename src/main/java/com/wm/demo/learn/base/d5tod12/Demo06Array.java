package com.wm.demo.learn.base.d5tod12;

import java.util.Arrays;

public class Demo06Array {

	public static void main(String[] args) {
		int[] arr = { 24, 69, 80, 57, 13 };
		System.out.println("排序前：");
		printArray(arr);bubbleSort(arr);
		System.out.println("排序后：");
		printArray(arr);
		
		
		//定义一个数组
		int[] arr2 = {11,22,33,44,55,66,77};
		
		//写功能实现
		int index = getIndex(arr2, 33);
		System.out.println("index:"+index);
		
		//假如这个元素不存在后有什么现象呢?
		index = getIndex(arr2, 333);
		System.out.println("index:"+index);
		
		Arrays.sort(arr);//底层为快速排序
		
		System.out.println(Arrays.binarySearch(arr2, 22));
		
	}
	
	//冒泡排序代码
	public static void bubbleSort(int[] arr){
		for (int x = 0; x < arr.length - 1; x++) {
			for (int y = 0; y < arr.length - 1 - x; y++) {
				if (arr[y] > arr[y + 1]) {
					int temp = arr[y];
					arr[y] = arr[y + 1];
					arr[y + 1] = temp;
				}
			}
		}
	}
	
	public static void selectSort(int[] arr){
		for(int x=0; x<arr.length-1; x++){
			for(int y=x+1; y<arr.length; y++){
				if(arr[y] <arr[x]){
					int temp = arr[x];
					arr[x] = arr[y];
					 arr[y] = temp;
				}
			}
		}
	}
	
	/*
	 * 两个明确：
	 * 返回值类型：int
	 * 参数列表：int[] arr,int value
	 */
	public static int getIndex(int[] arr,int value){
		//定义最大索引，最小索引
		int max = arr.length -1;
		int min = 0;
		
		//计算出中间索引
		int mid = (max +min)/2;
		
		//拿中间索引的值和要查找的值进行比较
		while(arr[mid] != value){
			if(arr[mid]>value){
				max = mid - 1;
			}else if(arr[mid]<value){
				min = mid + 1;
			}
			
			//加入判断
			if(min > max){
				return -1;
			}
			
			mid = (max +min)/2;
		}
		
		return mid;
	}

	// 遍历功能
	public static void printArray(int[] arr) {
		System.out.print("[");
		for (int x = 0; x < arr.length; x++) {
			if (x == arr.length - 1) {
				System.out.print(arr[x]);
			} else {
				System.out.print(arr[x] + ", ");
			}
		}
		System.out.println("]");
	}
	
}
