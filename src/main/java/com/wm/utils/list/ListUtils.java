package com.wm.utils.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ListUtils {

	/**
	 * ids转化为特殊ids
	 * @param ids  1111,2222
	 * @param regrex ,
	 * @param newRegrex '
	 * @return '1111','2222'
	 */
	public static String getFIdsFromIds(String ids,String regrex,String newRegrex){
		if("".equals(ids.trim())||ids.trim().equals(regrex.trim())){
			return "";
		}
		
		List<String> idList = getListFromIds(ids, regrex);
		
		StringBuffer fids = new StringBuffer();
		for(String id : idList){
			fids.append(newRegrex).append(id).append(newRegrex).append(regrex);
		}
		fids.deleteCharAt(fids.length() - 1);//去掉最后一个 regrex
		
		return fids.toString();
	}
	
	/**
	 * ids转化为idList
	 * @param ids  1111,2222 或 1111 或 ,
	 * @param regrex
	 * @return List
	 */
	public static List<String> getListFromIds(String ids,String regrex){
		if("".equals(ids.trim())){
			return new ArrayList<String>();
		}
		
		List<String> idList = Arrays.asList(ids.split(regrex));
		return idList;
	}
	
	/**
	 * idList转化为ids
	 * @param list
	 * @param regrex
	 * @return ids
	 */
	public static String getIdsFromList(List<String> list,String regrex){
		
		if(list.size()==0){
			return "";
		}
		StringBuffer ids = new StringBuffer();
		for(String id : list){
			ids.append(id).append(regrex);
		}
		ids.deleteCharAt(ids.length() - 1);//去掉最后一个 regrex
		
		return ids.toString();
	}
	
	/**
	 * 去除重复元素
	 * @param list
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void removeDuplicate(List list)  {
		 HashSet h  =  new HashSet(list);
		 list.clear();
		 list.addAll(h);
	}
	
	/**
	 * idList转化为特殊ids
	 * @param list
	 * @param regrex
	 * @param regrex2
	 * @return ids
	 */
	public static String getIdsFromList(List<String> list,String regrex,String regrex2){
		
		if(list.size()==0){
			return "";
		}
		StringBuffer ids = new StringBuffer();
		for(String id : list){
			ids.append(regrex2).append(id).append(regrex2).append(regrex);
		}
		ids.deleteCharAt(ids.length() - 1);//去掉最后一个 regrex
		
		return ids.toString();
	}
	
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("111");
		list.add("111");
		list.add("111");
		list.add("111");
		
		System.out.println(getIdsFromList(list, ",","'"));
	}
	
}
