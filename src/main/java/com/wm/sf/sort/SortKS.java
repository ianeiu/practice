package com.wm.sf.sort;

/**
 * @Description: SortKS
 * @author: wm
 * @date: 2019年1月7日 下午5:06:03
 * @version: 1.0
 */
public class SortKS extends TemplateSort{

	private static final String NAME = "快速排序";

	@Override
	public String getSortName() {
		return NAME;
	}
	@Override
	public void sort(int[] array) {
		//数组的左边界(例如，从起始位置开始排序，则l=0)
		int l = 0;
		//数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
		int r = array.length-1;
		
		if (l < r){
	        int i,j,x;

	        i = l;
	        j = r;
	        x = array[i];
	        while (i < j){
	            while(i < j && array[j] > x)
	                j--; // 从右向左找第一个小于x的数
	            if(i < j)
	                array[i++] = array[j];
	            while(i < j && array[i] < x)
	                i++; // 从左向右找第一个大于x的数
	            if(i < j)
	                array[j--] = array[i];
	        }
	        array[i] = x;
	        quick_sort(array, l, i-1); /* 递归调用 */
	        quick_sort(array, i+1, r); /* 递归调用 */
	    }
	}
	
	
	public void quick_sort(int a[], int l, int r){
	    if (l < r){
	        int i,j,x;

	        i = l;
	        j = r;
	        x = a[i];
	        while (i < j){
	            while(i < j && a[j] > x)
	                j--; // 从右向左找第一个小于x的数
	            if(i < j)
	                a[i++] = a[j];
	            while(i < j && a[i] < x)
	                i++; // 从左向右找第一个大于x的数
	            if(i < j)
	                a[j--] = a[i];
	        }
	        a[i] = x;
	        quick_sort(a, l, i-1); /* 递归调用 */
	        quick_sort(a, i+1, r); /* 递归调用 */
	    }
	}
	

}
