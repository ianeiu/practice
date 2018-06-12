package com.wm.demo.trywork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.net.ftp.FTPClient;

public class PushMiWenFile {
	public static void main(String[] args) {
		System.out.println(new Date().getTime()+"  开始推送");
		
		//加载配置文件
		String ftpInfoUrl = PushMiWenFile.class.getResource("push_file.properties").getPath();// 正式环境
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(ftpInfoUrl));
		} catch (FileNotFoundException e1) {
			System.out.println("========================================");
			System.out.println("==============加载配置文件出现异常==============");
			System.out.println("========================================");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println("========================================");
			System.out.println("==============加载配置文件出现异常==============");
			System.out.println("========================================");
			e1.printStackTrace();
		}
		String sourcePath = prop.getProperty("sourcePath","F://");//数分室存放密文的电脑路径
		boolean isFR = Boolean.parseBoolean(prop.getProperty("firstRun","false"));//是否第一次推送

		//获取已推送文件集合
		Set<String> pushedFileSet = null;//=========================已推送文件集合=========================
		try {
			pushedFileSet = FileUtil.getPushedFile();
		} catch (IOException e) {
			System.out.println("========================================");
			System.out.println("=============获取已推送文件出现异常=============");	
			System.out.println("========================================");
			e.printStackTrace();
		}

		while(true){
			//初始化FTP
			FTPClient ftp = null;
			try {
				ftp = FTPUtil.getFTPClient();
			} catch (Exception e) {}
			
			//int sleepHour = 3600000*(Integer.parseInt(prop.getProperty("sleepTime","3")));//推送休息时间   //3600000=1 hour
			int sleepHour = 3000*(Integer.parseInt(prop.getProperty("sleepTime","3")));//测试
			
			List<String> localFilePathlist = FileUtil.getAllTxtFilePaths(new File(sourcePath),isFR);//=========================需推送的本地文件集合=========================
			
			//开始推送
			try {
				for (String localFilePath : localFilePathlist) {
					if(!pushedFileSet.contains(localFilePath)){	//如果Set集合没有此值，则推送FTP、添加至Set、持久化至文件
						File tempFile = new File(localFilePath);
						boolean result = FTPUtil.uploadFile(ftp,tempFile.getName(), new FileInputStream(tempFile));//推送FTP
						if(result){
							//if(
							pushedFileSet.add(localFilePath);//添加至Set
							//){	//如果Set集合没有此值，则添加且持久化
							FileUtil.contentToTxt(localFilePath);//持久化至文件
							//}
						}
					}
				}
			} catch (IOException e) {
				System.out.println("========================================");
				System.out.println("==============推送至FTP出现异常==============");
				System.out.println("========================================");
				e.printStackTrace();
				return;
			}
			
			// 修改配置文件为非第一次重启
			if (isFR) {
				isFR = false;
				prop.setProperty("firstRun", "false");
				OutputStream out = null;
				try {
					out = new FileOutputStream(new File(ftpInfoUrl));
					prop.store(out,"");
				} catch (IOException e) {
					System.out.println("========================================");
					System.out.println("==============修改配置文件出现异常=============");
					System.out.println("========================================");
					e.printStackTrace();
				} finally {
					if (out != null) {
						try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			if(ftp!=null && ftp.isConnected()){
				try {
					ftp.disconnect();
				} catch (IOException e) {}
			}
			
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"  推送完毕");
			System.out.println("==============================================================");
			System.out.println("==========================等待下次推送============================");
			
			try {
				if(TimeUtils.isBelong("21:00", "23:30")){
					sleepHour = 3600000/3;//20分钟
				}else if(TimeUtils.isBelong("21:31", "23:59")){
					sleepHour = 3600000/10;//6分钟
				}
				Thread.sleep(sleepHour);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


/**
 * File
 * @author wm
 *
 */
class FileUtil{
	/**
	 * 获取已推送文件集合
	 * @throws IOException 
	 */
	public static Set<String> getPushedFile() throws IOException{
		Set<String> set = new HashSet<String>();
		
		String pushedfileurl = FileUtil.class.getResource("pushed_file.txt").getPath();// 正式环境
		File file = new File(pushedfileurl);
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try{
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			String read = null;
			while ((read = bufferedReader.readLine()) != null) {
				set.add(read);
			}
		}finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
	    		
			} 
		}
		return set;
	}
	
	/**
	 * 追加内容至txt
	 * @param content
	 * @throws IOException
	 */
	public static void contentToTxt(String content) throws IOException {
		String filePath = FileUtil.class.getResource("pushed_file.txt").getPath();// 正式环境
		String str = new String(); // 原有txt内容
		String s1 = new String();// 内容更新

		File f = new File(filePath);
		BufferedReader input = null;
		BufferedWriter output = null;
		try{
			input = new BufferedReader(new FileReader(f));
	
			while ((str = input.readLine()) != null) {
				s1 += str + "\n";
			}
			s1 += content;
			output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"GBK"));
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
	 * 获取当天或全部文件集合
	 * @param srcFolder
	 * @param isFirstRun
	 * @return
	 */
	public static List<String> getAllTxtFilePaths(File srcFolder,boolean isFirstRun) {
		String dateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
		List<String> list = new ArrayList<String>();
		// 获取该目录下所有的文件或者文件夹的File数组
		File[] fileArray = srcFolder.listFiles();

		if (isFirstRun) { 
			for (File file : fileArray) {
				File[] fileDateArray = file.listFiles();
				for (File fileDate : fileDateArray) {
					File[] itemFiles = fileDate.listFiles();
					for (File itemFile : itemFiles) {
						if (itemFile.getName().endsWith(".txt")) {	// 判断是否以.txt结尾
							list.add(itemFile.getAbsolutePath());
						}
					}
				}
			}
		}else{	// 只推送当天数据
			for (File file : fileArray) {
				File[] fileDateArray = file.listFiles();
				for (File fileDate : fileDateArray) {
					if (dateStr.equals(fileDate.getName())) {	// 判断是否是当天命名文件夹
						File[] itemFiles = fileDate.listFiles();
						for (File itemFile : itemFiles) {
							if (itemFile.getName().endsWith(".txt")) {	// 判断是否以.txt结尾
								list.add(itemFile.getAbsolutePath());
							}
						}
					}
				}
			}
		}
		
		return list;
	}
	
}



/**
 * FTP
 * @author wm
 *
 */
class FTPUtil{
	private static String user;
	private static String pwd;
	private static String host;
	private static int port;
	private static String localCharset;
	private static String serverCharset;
	private static String path;
	private static String model;
	
	public static FTPClient getFTPClient() throws FileNotFoundException, IOException, Exception {
		FTPClient ftp = new FTPClient();
		String ftpInfoUrl = FTPUtil.class.getResource("push_file.properties").getPath();// 正式环境
		Properties prop = new Properties();
		prop.load(new FileInputStream(ftpInfoUrl));
	
		user = prop.getProperty("user", "MMPsys");
		pwd = prop.getProperty("pwd", "MMP123");
		host = prop.getProperty("host", "10.10.0.118");
		port = Integer.valueOf(prop.getProperty("port", "21"));
		localCharset = prop.getProperty("localCharset", "GBK");
		serverCharset = prop.getProperty("serverCharset", "ISO-8859-1");
		path = prop.getProperty("path", "miwen");
		model = prop.getProperty("model", "active");

		ftp.connect(host, port);// 连接FTP服务器
		boolean isLogin = ftp.login(user, pwd);// 登陆FTP服务器
		if (!isLogin) {
			throw new Exception("连接FTP出现错误，原因：用户名或密码错误");
		}
		return ftp;
	}
	
	 /**  
     * 向FTP服务器上传文件  
     * @param filename 上传到FTP服务器上的文件名  
     * @param input 输入流 
     * @return 成功返回true，否则返回false  
	 * @throws IOException
     */    
    public static boolean uploadFile(FTPClient ftp,String filename, InputStream input) throws IOException  {  
    	
    	boolean success = false; 
    	try{
    		ftp.changeWorkingDirectory(path);
	    	ftp.setControlEncoding(localCharset);
	    	if("active".equals(model)){
	    		ftp.enterLocalActiveMode();
	    	}else{
	    		ftp.enterLocalPassiveMode();
	    	}
	    	ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
	    	filename = new String(filename.getBytes(localCharset), serverCharset);
	    	success = ftp.storeFile(filename, input); 
	    	//ftp.logout(); 
    	} finally { 
	    	try {
	    		if(input!=null){
					input.close();
	    		}
			} catch (IOException e) {
	    		
			} 
    	} 
    	return success; 
    } 
}

/**
 * Time
 * @author wm
 *
 */
class TimeUtils {
	public static boolean isBelong(String start,String end) {

		SimpleDateFormat df = new SimpleDateFormat("HH:mm");// 设置日期格式
		Date now = null;
		Date beginTime = null;
		Date endTime = null;
		try {
			now = df.parse(df.format(new Date()));
			beginTime = df.parse(start);
			endTime = df.parse(end);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Boolean flag = belongCalendar(now, beginTime, endTime);
		return flag;
	}

	/**
	 * 判断时间是否在时间段内
	 * 
	 * @param nowTime
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
		return nowTime.getTime() >= beginTime.getTime() && nowTime.getTime() <= endTime.getTime();  
	}
}

