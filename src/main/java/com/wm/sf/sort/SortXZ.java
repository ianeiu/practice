package com.wm.sf.sort;

/**
 * @Description: SortXZ
 * @author: wm
 * @date: 2019年1月7日 下午5:32:22
 * @version: 1.0
 */
public class SortXZ extends TemplateSort{

	private static final String NAME = "选择排序";

	@Override
	public String getSortName() {
		return NAME;
	}

	@Override
	public void sort(int[] array) {
		int len = array.length;
		for (int i = 0, k = 0; i < len; i++, k = i) {
			// 在这一层循环中找最小
			for (int j = i + 1; j < len; j++) {
				// 如果后面的元素比前面的小，那么就交换下标，每一趟都会选择出来一个最小值的下标
				if (array[k] > array[j]){
					k = j;
				}
			}

			if (i != k) {
				int tmp = array[i];
				array[i] = array[k];
				array[k] = tmp;
			}
		}
	}

}
