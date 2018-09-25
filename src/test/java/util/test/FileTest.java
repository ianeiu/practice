package util.test;

import java.io.File;
import java.io.IOException;

import com.wm.utils.file.FileUtil;

public class FileTest {

	@org.junit.Test
	public void testCopy() throws IOException{
		
		FileUtil.fileCopy(new File("test_file/name.txt"), new File("C:\\Users\\admin\\Desktop\\xixi.txt"));
	}
}
