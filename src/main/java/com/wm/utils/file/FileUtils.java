package com.wm.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.wm.utils.id.IDUtils;

public class FileUtils {

    private final static transient Logger logger = LoggerFactory.getLogger(FileUtils.class);
    
    /**
     * 上传文件
     * @param saveDirPath 文件保存目录
     * @param fileName 文件名
     * @param uploadFile 文件
     * @param ifBefore 文件保存地址是否增加前缀。 若是。。。\201803150012321_批量上架稽核表.xlsx，若否。。。\批量上架稽核表.xlsx
     * @return 文件保存地址
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String uploadFile(String saveDirPath,String fileName,File uploadFile,boolean ifBefore) throws FileNotFoundException,IOException{
	    
    	File tmpFile = new File(saveDirPath);
    	
	    if (!tmpFile.exists()) {
	        tmpFile.mkdirs(); //创建目录
	    }

	    String filePath = "";//文件保存地址
	    if(ifBefore){
	    	filePath = tmpFile.getPath() +"/"+ IDUtils.genImageName()+"_"+fileName; 
	    }else{
	    	filePath = tmpFile.getPath() +"/"+fileName; 
	    }
	    		
	    OutputStream os = new FileOutputStream(filePath);
	 
	    byte[] bs = new byte[1024];   // 1K的数据缓冲
	    int len;// 读取到的数据长度
	    
	    // 开始读取
	    FileInputStream fin = new FileInputStream(uploadFile);
	    while ((len = fin.read(bs)) != -1) {
	        os.write(bs, 0, len);
	    }
	    try {
		    os.close();
			fin.close();
		} catch (IOException e) {
			logger.error("关闭流出现错误",e);
		}
	    
	    return filePath;
    }
    
    /**
     * 删除文件
     * @param filePath
     * @return
     */
    public static boolean delFile(String filePath){
    	File file = new File(filePath);
    	boolean flag = false;
    	if(file.exists() && file.isFile()){
    		flag =  file.delete();
        }
    	return flag;
    }
    
    /**
     * 使用NIO高效 拷贝文件 
     * @param in
     * @param out
     * @throws IOException
     */
	public static void fileCopy(File in, File out) throws IOException {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			// inChannel.transferTo(0, inChannel.size(), outChannel); //
			// original -- apparently has trouble copying large files on Windows

			// magic number for Windows, 64Mb - 32Kb)
			int maxCount = (64 * 1024 * 1024) - (32 * 1024);
			long size = inChannel.size();
			long position = 0;
			while (position < size) {
				position += inChannel.transferTo(position, maxCount, outChannel);
			}
		} finally {
			if (inChannel != null) {
				inChannel.close();
			}
			if (outChannel != null) {
				outChannel.close();
			}
		}
	}
	

    /**
     * 输入流转化为文件
     * @param ins
     * @param file
     * @throws Exception 
     */
	public static void inputstreamTofile(InputStream ins, File file) throws IOException {
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			throw new IOException(e);
		} finally {
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					
				}
			}
			if(ins != null){
				try {
					ins.close();
				} catch (IOException e) {
					
				}
			}
		}
	}
	
	/**
     * MultipartFile 转换成File
     * update by wm 2018.07.12
     * @param multfile 原文件类型
     * @return File
     * @throws IOException
     */
    public static File multipartToFile(MultipartFile multfile) throws IOException {
    	//Springboot自带上传不支持CommonsMultipartFile
        //CommonsMultipartFile cf = (CommonsMultipartFile)multfile;
        //这个myfile是MultipartFile的
        //DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        //return fi.getStoreLocation();

		File f = null;
		if ("".equals(multfile) || multfile.getSize() <= 0) {
			multfile = null;
		} else {
			InputStream ins = multfile.getInputStream();
			f = new File(multfile.getOriginalFilename());
			inputstreamTofile(ins, f);
		}
		return f;
    }
	
}
