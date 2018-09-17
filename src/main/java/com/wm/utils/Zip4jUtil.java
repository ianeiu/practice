package com.wm.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipOutputStream;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class Zip4jUtil {
	
	
//	public static void main(String[] args) {
//		new Zip4jUtil().CreateZipWithOutputStreamsStandardEnc();
//	}

	/**
	 * 解密解压
	 * @param file 压缩文件
	 * @param pwd 密码
	 * @param dstPath 目的地址
	 * @throws ZipException
	 */
	public static void decompressByPwd(File file,String pwd,String dstPath) throws ZipException {
		ZipFile srcFile = new ZipFile(file);
		srcFile.setFileNameCharset("GBK");
		srcFile.setPassword(pwd.toCharArray());
		srcFile.extractAll(dstPath);
	}
	
	/**
	 * 加密压缩
	 * @param sourceFile 需要压缩的文件集
	 * @param orderFile 目的地址
	 * @return 压缩密码
	 */
	public static String compressWithPwd(List<File> sourceFile,String orderFile) {
		ZipOutputStream outputStream = null;
		InputStream inputStream = null;
		String passwork = Zip4jUtil.getPasswork(6);//设置密码  参数：密码位数
		try {
			ArrayList<File> filesToAdd = new ArrayList<File>();
			for(File f : sourceFile){
				filesToAdd.add(f);
			}
			outputStream = new ZipOutputStream(new FileOutputStream(new File(orderFile)));
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			parameters.setEncryptFiles(true);
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
			parameters.setPassword(passwork);
			
			for (int i = 0; i < filesToAdd.size(); i++) {
				File file = filesToAdd.get(i);
				outputStream.putNextEntry(file,parameters);
				if (file.isDirectory()) {
					outputStream.closeEntry();
					continue;
				}
				inputStream = new FileInputStream(file);
				byte[] readBuff = new byte[4096];
				int readLen = -1;
				while ((readLen = inputStream.read(readBuff)) != -1) {
					outputStream.write(readBuff, 0, readLen);
				}
				outputStream.closeEntry();
				inputStream.close();
			}
			outputStream.finish();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return passwork;
	}
	
	public static String getPasswork(int length){
		String[] text = {"1","2","3","4","5","6","7","8","9","0","a","b","c","d","e","f","g","h","i","j"};
		Random random = new Random();
		String str = ""; 
		for(int i=0;i<length;i++){
			str += text[random.nextInt(20)];
		}
		return str;
	}
}
