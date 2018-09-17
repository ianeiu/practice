package util.test;

import org.junit.Test;

import com.wm.utils.IDUtils;

public class IDTest {
	
	@Test
	public void test1() {
		String s = IDUtils.genImageName();
		Long l = IDUtils.genItemId();
		
		System.out.println(s);
		System.out.println(l);

	}
	
	@Test
	public void test2(){
		System.out.println(IDUtils.getRandomString(20));
	}
}
