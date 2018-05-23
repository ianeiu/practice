package com.wm.utils.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtUtil {

	/**
	 * 创建文件
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean createFile(File file) throws Exception {
		boolean flag = false;
		if (!file.exists()) {
			file.createNewFile();
			flag = true;
		}
		return flag;
	}

	/**
	 * 读TXT文件内容
	 * 
	 * @param fileName
	 * @return
	 */
	public static String readTxtFile(File file) throws Exception {
		String result = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		try {
			String read = null;
			while ((read = bufferedReader.readLine()) != null) {
				result = result + read + "\r\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		if (bufferedReader != null) {
			bufferedReader.close();
		}
		if (fileReader != null) {
			fileReader.close();
		}
		return result;
	}
	
	/**
	 * 读TXT文件内容
	 * 
	 * @param path
	 * @return
	 * @throws IOException 
	 */
	public static List<String> readTxtFile2(String path) throws IOException{
		File file = new File(path);
		return readTxtFile2(file);
	}
	
	/**
	 * 读TXT文件内容
	 * 
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
	 * 写入Txt
	 * 
	 * @param content
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static boolean writeTxtFile(String content, File file)
			throws Exception {
		// RandomAccessFile mm = null;
		boolean flag = false;
		FileOutputStream o = null;

		o = new FileOutputStream(file);
		o.write(content.getBytes("GBK"));
		o.close();
		// mm=new RandomAccessFile(fileName,"rw");
		// mm.writeBytes(content);
		flag = true;

		// if (mm != null) {
		// mm.close();
		// }
		return flag;
	}

	/**
	 * 追加内容至txt
	 * 
	 * @param filePath
	 * @param content
	 * @throws IOException
	 */
	public static void contentToTxt(String filePath, String content) throws IOException {
		String str = new String(); // 原有txt内容
		String s1 = new String();// 内容更新

		File f = new File(filePath);
		if (f.exists()) {
			System.out.println("文件存在");
		} else {
			System.out.println("文件不存在");
			f.createNewFile();// 不存在则创建
		}
		BufferedReader input = new BufferedReader(new FileReader(f));

		while ((str = input.readLine()) != null) {
			s1 += str + "\n";
		}
		System.out.println(s1);
		input.close();
		s1 += content;

		BufferedWriter output = new BufferedWriter(new FileWriter(f));
		output.write(s1);
		output.close();
	}
	
	/**
	 * 
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

	
}