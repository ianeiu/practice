package com.wm.sf.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainSort {
	public static void main(String[] args) {

		int[] array = initData(300);
		int[] array2 = array.clone();
		int[] array3 = array.clone();
		//int[] array4 = array.clone();
		
		TemplateSort mpsort = new SortMP();
		mpsort.sortPrintln(array);
		
		mpsort = new SortXZ();
		mpsort.sortPrintln(array2);
		
		mpsort = new SortKS();
		mpsort.sortPrintln(array3);
	}
	
	
	private static int[] initData(int num){
		List<String> list = new ArrayList<>();
		for(int i=0;i<num;i++){
			list.add(stringRandom(1, 10000));
		}
		
		int[] array = list.stream().mapToInt(s -> Integer.parseInt(s)).toArray();
		return array;
	}
	
	/**
     * 生成制定范围内的随机数
     *
     * @param scopeMin
     * @param scoeMax
     * @return
     */
    public static String stringRandom(int scopeMin, int scoeMax) {
        Random random = new Random();
        return Integer.toString((random.nextInt(scoeMax) % (scoeMax - scopeMin + 1) + scopeMin));
    }
}
