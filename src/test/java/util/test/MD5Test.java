package util.test;

import org.junit.Test;

import com.wm.utils.pwd.MD5Utils;

public class MD5Test {

	@Test
	public void getMD5Str(){
		System.out.println(MD5Utils.getMD5Str("123456"));
		byte[] b = MD5Utils.getMD5("123456", "utf-8");
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]);
		}
	}
	
}
