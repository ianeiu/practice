package com.wm.sf.query;

public class QueryDemo {

	public static void main(String[] args) {
		int[] sz = {2,6,33,35,40,50};
		System.out.println(sequenceSearch(sz, 50));
		System.out.println(binarySearch(sz, 50));
	}
	
	/**
	 * @Description:顺序查找 
	 * @author: wm
	 * @date: 2018年12月19日 上午10:12:55
	 * @version: 1.0
	 * @param sz
	 * @param key
	 * @return
	 */
    public static int sequenceSearch(int[] sz, int key) {
        for (int i = 0; i < sz.length; i++) {
            if (sz[i] == key) {
                return i;
            }
        }
        return -1;
    }
	
	/**
	 * @Description:二分法 (数据先排好序)
	 * @author: wm
	 * @date: 2018年12月19日 上午10:12:05
	 * @version: 1.0
	 * @param sz
	 * @param key
	 * @return
	 */
	public static int binarySearch(int[] sz,int key){
        int low = 0;
        int high = sz.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if(sz[middle] == key){
                return middle;
            }else if(sz[middle] > key){
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
