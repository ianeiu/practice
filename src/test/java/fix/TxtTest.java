package fix;

import java.io.File;

import org.junit.Test;

import com.wm.utils.txt.TxtUtil;

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

}
