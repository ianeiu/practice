package util.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.wm.utils.json.JSONUtil;

import util.vo.UserVO;

public class JSONTest {

	@Test
	public void jsonTest(){
		List<UserVO> list = new ArrayList<UserVO>();
		
		UserVO vo  = new UserVO();
		vo.setId("1111");
		vo.setName("吾未眠");
		vo.setPassword("2131a");
		
		System.out.println(JSONUtil.objectToString(vo));
		
		list.add(vo);
		
		UserVO vo2  = new UserVO();
		vo2.setId("2222");
		vo2.setName("呵呵哒");
		vo2.setPassword("2131a");
		
		list.add(vo2);
		
		System.out.println(JSONUtil.arrayToString(list));
		
		String s = JSONUtil.xmlToJsonString("<books><book><name>鲁滨孙漂流记</name><price>12$</price></book><book><name>西游记</name><price>122$</price></book></books>");
		System.out.println(s);
	}
}
