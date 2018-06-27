package com.wm.demo.gson;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wm.demo.gson.vo.UserForExposeVO;
import com.wm.demo.gson.vo.UserForSerializedNameVO;
import com.wm.demo.gson.vo.UserForSinceVO;
import com.wm.demo.gson.vo.UserForUntilVO;

/**
 * 
 * @author wm
 *
 */
public class GsonAnnotationDemo {
	private Gson gson;

	private static void log(String msg) {
		System.out.println(msg);
	}

	@Before
	public void init() {
		gson = new Gson();
	}
	
	//@SerializedName
	@Test
	public void testJsonStrConvertSimpleBean(){
		String voStr = "{\"id\":\"12123sds\",\"userName\":\"吾未眠\",\"userSex\":\"man\",\"pwd\":\"asdad\"}";
		UserForSerializedNameVO vo = gson.fromJson(voStr,
				UserForSerializedNameVO.class);
		log("------->json convert JavaBean:" + vo);
	}

	@Test
	public void testJsonStrConvertSimpleBean2() {
		String voStr = "{\"id\":\"12123sds\",\"name\":\"吾未眠\",\"userSex\":\"man\",\"pwd\":\"asdad\"}";
		UserForSerializedNameVO vo = gson.fromJson(voStr,
				UserForSerializedNameVO.class);
		log("------->json convert JavaBean:" + vo);
	}

	@Test
	public void testExpose() {
		String jsonFromServer = "{\"id\":\"12123sds\",\"userName\":\"吾未眠\",\"userSex\":\"man\",\"password\":\"asdad\"}";
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		UserForExposeVO user = gson.fromJson(jsonFromServer, UserForExposeVO.class);
		log("------>反序列化:" + user);

		UserForExposeVO user1 = new UserForExposeVO();
		user1.setUserName("老吾");
		user1.setId("1321sad");
		user1.setPassword("asdasd");
		user1.setUserSex("male");
		String userStr = gson.toJson(user1);
		log("------>序列化:" + userStr);
	}
	
	@Test
	public void testSince() {
		String jsonFromServer = "{\"id\":\"12123sds\",\"userName\":\"吾未眠\",\"userSex\":\"man\",\"password\":\"asdad\"}";
		Gson gson = new GsonBuilder().setVersion(1)// 版本为1
				.create();
		UserForSinceVO vo = gson.fromJson(jsonFromServer, UserForSinceVO.class);
		log("------>反序列化v=1:" + vo);  
		
		UserForSinceVO user = new UserForSinceVO();
		user.setUserName("老吾");
		user.setId("1321sad");
		user.setPassword("asdasd");
		user.setUserSex("male");
		String userStr = gson.toJson(user);
		log("------>序列化v=1:" + userStr);
		
		
		Gson gson2 = new GsonBuilder().setVersion(2)// 版本为2
				.create();
		UserForSinceVO vo2 = gson2.fromJson(jsonFromServer, UserForSinceVO.class);
		log("------>反序列化v=2:" + vo2);
		UserForSinceVO user2 = new UserForSinceVO();
		user2.setUserName("老吾");
		user2.setId("1321sad");
		user2.setPassword("asdasd");
		user2.setUserSex("male");
		String userStr2 = gson2.toJson(user2);
		log("------>反序列化v=1:" + userStr2);
	
	}
	
	@Test
	public void testUntil(){
		String jsonFromServer = "{\"id\":\"12123sds\",\"userName\":\"吾未眠\",\"userSex\":\"man\",\"password\":\"asdad\"}";
		Gson gson = new GsonBuilder().setVersion(1)// 版本为1
				.create();
		UserForUntilVO vo = gson.fromJson(jsonFromServer, UserForUntilVO.class);
		log("------>反序列化v=1:" + vo);  
		
		UserForUntilVO user = new UserForUntilVO();
		user.setUserName("老吾");
		user.setId("1321sad");
		user.setPassword("asdasd");
		user.setUserSex("male");
		String userStr = gson.toJson(user);
		log("------>序列化v=1:" + userStr);
		
		
		Gson gson2 = new GsonBuilder().setVersion(2)// 版本为2
				.create();
		UserForUntilVO vo2 = gson2.fromJson(jsonFromServer, UserForUntilVO.class);
		log("------>反序列化v=2:" + vo2);
		UserForUntilVO user2 = new UserForUntilVO();
		user2.setUserName("老吾");
		user2.setId("1321sad");
		user2.setPassword("asdasd");
		user2.setUserSex("male");
		String userStr2 = gson2.toJson(user2);
		log("------>序列化v=2:" + userStr2);
	}
}
