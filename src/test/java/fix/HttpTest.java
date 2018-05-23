package fix;

import org.junit.Test;

import com.wm.utils.http.HttpRequestProxy;
import com.wm.utils.http.HttpRequestSimple;

public class HttpTest {
	@Test
	public void sendPost(){
		String url = "http://baike.baidu.com/api/openapi/BaikeLemmaCardApi";
		String param = "scope=103&format=json&appid=379020&bk_key=关键字&bk_length=600";
		System.out.println(HttpRequestSimple.sendPost(url, param));
	}
	
	/**
	 * 内网代理访问
	 */
	@Test
	public void sendGetProxy(){
		String url = "http://baike.baidu.com/api/openapi/BaikeLemmaCardApi";
		String param = "scope=103&format=json&appid=379020&bk_key=关键字&bk_length=600";
		System.out.println(HttpRequestProxy.sendPost(url, param, true));
	}
	
	/**
	 * 内网代理访问
	 */
	@Test
	public void sendGetProxy2(){
		String url = "http://tcc.taobao.com/cc/json/mobile_tel_segment.htm";
        String para = "tel=15816789113";
        String sr=HttpRequestProxy.sendPost(url,para,true);
        System.out.println(sr);
	}
}
