package com.wm.sf.sort;

public abstract class TemplateSort {
	
	public void sortPrintln(int[] array){
		println(array);
		System.out.println(getSortName()+"开始：");
		long start = System.currentTimeMillis();
		sort(array);
		long end = System.currentTimeMillis();
		println(array);
		System.out.println("耗时 "+(end-start)+" 毫秒");
		System.out.println("----------------------------");
	}
	
	public abstract String getSortName();
	
	public abstract void sort(int[] array);
	
	private static void println(int[] array){
		for(int i:array){
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
