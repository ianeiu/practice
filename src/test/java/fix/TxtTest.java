package fix;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.wm.utils.file.TxtUtil;

public class TxtTest {
	
	@Test
	public void testC() throws Exception {
		File file = new File("G:\\2017122701.txt");
		TxtUtil.createFile(file);
	}

	@Test
	public void testW() throws Exception {
		File file = new File("G:\\20171227.txt");
		TxtUtil.writeTxtFile("124343\r\n231232423\r\nadsaasdas123", file);
	}
	
	@Test
	public void testR() throws Exception {
		File file = new File("G:\\20171227.txt");
		TxtUtil.readTxtFile(file);
	}
	
	@Test
	public void testZ() throws Exception {
		TxtUtil.contentToTxt("G:\\20171227.txt", "213214sd\r\n");
	}

	@Test
	public void testCount() throws IOException{
		String path = "C:\\Users\\admin\\Desktop\\temp.txt";
		System.out.println(TxtUtil.countLines(path));
	}
}
