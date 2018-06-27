package com.wm.demo.gson;

import java.io.IOException;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.wm.demo.gson.vo.UserVO;

public class TypeAdapterDemo {

	private static void log(String msg) {
		System.out.println(msg);
	}

	@Test
	public void testTypeAdapter() throws IOException {  
        Gson gson = new Gson();  
        TypeAdapter<UserVO> userTypeAdapter = gson.getAdapter(UserVO.class);
        UserVO user = new UserVO();  
        user.setId("213");
        user.setUserName("吾未眠");
        user.setUserSex("man");
        user.setPassword("13123");
        String userJsonStr = userTypeAdapter.toJson(user);  
        log("------>序列化:" + userJsonStr);  
  
        UserVO user1 = userTypeAdapter.fromJson(userJsonStr);  
        log("------>反序列化:" + user1);  
  
    }  
	
}
