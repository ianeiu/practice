package com.wm.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
}
