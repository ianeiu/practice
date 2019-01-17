package com.wm.sf.sort;

/**
 * @Description: 冒泡排序
 * @author: wm
 * @date: 2019年1月7日 下午2:20:03
 * @version: 1.0
 */
public class SortMP extends TemplateSort {

	private static final String NAME = "冒泡排序";

	@Override
	public String getSortName() {
		return NAME;
	}
	
	public void sort(int[] array) {
		for(int i=0;i<array.length-1;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]>array[j]){
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
	}

}
