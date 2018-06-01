package fix;

import java.io.File;
import java.io.IOException;

import com.wm.utils.file.FileUtils;

public class FileTest {

	@org.junit.Test
	public void testCopy() throws IOException{
		
		FileUtils.fileCopy(new File("name.txt"), new File("C:\\Users\\admin\\Desktop\\xixi.txt"));
	}
}
