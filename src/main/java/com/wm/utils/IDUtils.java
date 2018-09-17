package com.wm.utils;

import java.util.Random;
import java.util.UUID;

public class IDUtils {
	/** 
     * 图片名生成 
     */  
    public static String genImageName() {  
        //取当前时间的长整形值包含毫秒  
        long millis = System.currentTimeMillis();  
        //long millis = System.nanoTime();  
        //加上三位随机数  
        Random random = new Random();  
        int end3 = random.nextInt(999);  
        //如果不足三位前面补0  
        String str = millis + String.format("%03d", end3);  
          
        return str;  
    }  
      
    /** 
     * 商品id生成 
     */  
    public static long genItemId() {  
        //取当前时间的长整形值包含毫秒  
        long millis = System.currentTimeMillis();  
        //long millis = System.nanoTime();  
        //加上两位随机数  
        Random random = new Random();  
        int end2 = random.nextInt(99);  
        //如果不足两位前面补0  
        String str = millis + String.format("%02d", end2);  
        long id = new Long(str);  
        return id;  
    }  
    
    /**
     * UUID
     * @return
     */
    public static String getUUID(){
    	String uuid = UUID.randomUUID().toString();
    	return uuid;
    }
    
    public static String getClearUUID(){
    	String uuid = getUUID().replace("-", "");
    	return uuid;
    }
    
    public static String getRandomString(int length) { //length表示生成字符串的长度  
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
        Random random = new Random();     
        StringBuffer sb = new StringBuffer();     
        for (int i = 0; i < length; i++) {     
            int number = random.nextInt(base.length());     
            sb.append(base.charAt(number));     
        }     
        return sb.toString();     
     }
}
