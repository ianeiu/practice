package util.test;

import org.junit.Test;

import com.wm.utils.PasswordUtil;

public class MD5Test {

	@Test
	public void getMD5Str(){
		System.out.println(PasswordUtil.getMD5Str("123456"));
		byte[] b = PasswordUtil.getMD5("123456", "utf-8");
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]);
		}
	}
	
}
