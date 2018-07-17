package util.test;

import java.io.File;

import org.junit.Test;

import com.wm.utils.zip.ZipUtil;

public class zipTest {
	@Test
	public void compress(){
		File srcFile = new File("C:\\Users\\wm\\Desktop\\HTML转义字符.docx");
		try {
			//ZipUtil.compress(srcFile);
			ZipUtil.compress("C:\\Users\\wm\\Desktop\\HTML转义字符.docx","C:\\Users\\wm\\Desktop\\CUserswmDesktop.zip");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
