package com.wm.utils.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TxtUtil {

	/**
	 * @Description:创建文件 
	 * @author: wm
	 * @date: 2018年8月20日 下午2:29:49
	 * @version: 1.1
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static boolean createFile(File file) throws IOException   {
		boolean flag = false;
		if (file.exists()) {
			flag = true;
		} else {
			file.createNewFile();
			flag = true;
		}
		return flag;
	}

	/**
	 * @Description:创建目录 
	 * @author: wm
	 * @date: 2018年8月20日 下午2:50:15
	 * @version: 1.0
	 * @param file
	 * @return
	 */
	public static boolean createDir(File file) {
		boolean flag = false;
		if (file.exists()) {
			flag = true;
		} else {
			file.mkdirs();
			flag = true;
		}
		return flag;
	}
	public static String readTxtFile(String path) throws IOException{
		return readTxtFile(new File(path));
	}

	/**
	 * @Description: 读TXT文件内容
	 * @author: wm
	 * @date: 2018年8月20日 下午2:35:28
	 * @version: 1.1 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String readTxtFile(File file) throws IOException{
		String result = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
		
			String read = null;
			while ((read = bufferedReader.readLine()) != null) {
				result = result + read + "\r\n";
			}
		} catch (FileNotFoundException e) {
			//do nothing
		}finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
		}
		return result;
	}
	
	/**
	 * @Description: 读TXT文件内容
	 * @author: wm
	 * @date: 2018年8月20日 下午2:35:41
	 * @version: 1.0
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static List<String> readTxtFile2(String path) throws IOException{
		File file = new File(path);
		return readTxtFile2(file);
	}
	
	/**
	 * @Description: 读TXT文件内容
	 * @author: wm
	 * @date: 2018年8月20日 下午2:35:48
	 * @version: 1.0
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static List<String> readTxtFile2(File file) throws IOException  {
		
		List<String> result = new ArrayList<String>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		
		String read = "";
		while ((read = bufferedReader.readLine()) != null) {
			if(!"".equals(read.trim()))
			result.add(read.trim());
		}
		
		try {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		} catch (IOException e) {
			
		}
		return result;
	}
	
	/**
	 * 写入TXT
	 * 
	 * @param filePath
	 * @param content
	 * @throws IOException
	 */
	public static void writeToTxt(String filePath,List<String> list) throws IOException {
		File file = new File(filePath);
		createFile(file);
		
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(filePath);
            bw = new BufferedWriter(fw);
            for(Object o : list){
                bw.write(o.toString());
                bw.newLine();
                bw.flush();
            }
        } finally {
        	try{
	        	if(fw!=null){
	                fw.close();
	        	}
	        	if(bw!=null){
	                bw.close();
	        	}
        	}catch(IOException e){}
        }
	}
	
	/**
	 * @Description: 写入TXT
	 * @author: wm
	 * @date: 2018年8月20日 下午3:22:33
	 * @version: 1.0
	 * @param content
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static boolean writeTxtFile(String content, String path) throws IOException  {
		File file = new File(path);
		return writeTxtFile(content,file);
	}
	
	
	/**
	 * @Description:写入TXT 
	 * @author: wm
	 * @date: 2018年8月20日 下午2:33:39
	 * @version: 1.1
	 * @param content
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static boolean writeTxtFile(String content, File file) throws IOException  {
		boolean flag = false;
		FileOutputStream o = null;
		try {
			createDir(file.getParentFile());
			createFile(file);
			o = new FileOutputStream(file);
			o.write(content.getBytes("GBK"));
			flag = true;
		} finally {
			try{
	        	if(o!=null){
	                o.close();
	        	}
        	}catch(IOException e){}
		}
		return flag;
	}

	/**
	 * @Description:追加内容至txt 
	 * @author: wm
	 * @date: 2018年8月20日 下午2:36:56
	 * @version: 1.0
	 * @param filePath
	 * @param content
	 * @throws IOException
	 */
	public static void contentToTxt(String filePath, String content) throws IOException {
		String str = new String(); // 原有txt内容
		String s1 = new String();// 内容更新

		File f = new File(filePath);
		BufferedReader input = null;
		BufferedWriter output = null;
		try{
			if (f.exists()) {
				System.out.println("文件存在");
			} else {
				System.out.println("文件不存在");
				f.createNewFile();// 不存在则创建
			}
			input = new BufferedReader(new FileReader(f));
	
			while ((str = input.readLine()) != null) {
				s1 += str + "\n";
			}
			System.out.println(s1);
			s1 += content;
	
			output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
		} finally {
			if(input !=null ){
				try {
					input.close();
				} catch (IOException e) {
					
				}
			}
			if (output !=null ) {
				try {
					output.close();
				} catch (IOException e) {
					
				}
			}
		}
		
	}
	
	/**
	 * @Description:统计文件行数 
	 * @author: wm
	 * @date: 2018年8月20日 下午2:37:07
	 * @version: 1.0
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static long countLines(String filename) throws FileNotFoundException{
		Scanner scanner = null;
		try{
			File file = new File(filename);
			if(!file.exists()){
				return 0L;
			}
			
			long count = 0;
			scanner= new Scanner(new FileInputStream(file));
			while (scanner.hasNextLine()) {
				if(!"".equals(scanner.nextLine().trim()))
					count++;
			}
			return count;
		}finally {
			if(scanner != null){
				scanner.close();
			}
		}
	}
	
	
	/**
	 * @Description: 清除TXT内容
	 * @author: wm
	 * @date: 2018年8月20日 下午2:37:13
	 * @version: 1.0
	 * @param filePath
	 * @throws IOException
	 */
	public static void clearContent(String filePath) throws IOException {
		FileOutputStream out = new FileOutputStream(filePath,false); 
		out.write(new String("").getBytes()); 
		if(out!=null){
			out.close(); 
		}
	}
	
	/**
	 * @Description:删除文件 
	 * @author: wm
	 * @date: 2018年8月20日 下午4:31:06
	 * @version: 1.0
	 * @param filePath
	 * @return
	 */
    public static boolean delFile(String filePath){
    	File file = new File(filePath);
    	boolean flag = false;
    	if(file.exists() && file.isFile()){
    		flag =  file.delete();
        }else{
        	flag = true;
        }
    	return flag;
    }

	
}