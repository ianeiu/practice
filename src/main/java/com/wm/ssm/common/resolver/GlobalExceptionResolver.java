package com.wm.ssm.common.resolver;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Maps;
import com.wm.ssm.common.constant.Constants;
import com.wm.ssm.common.exception.BusinessException;
import com.wm.ssm.common.vo.ResultVO;


/**
 * 认证系统统一处理异常类
 * @author FengHuayuan
 * @date 2018年5月2日 上午11:17:14.
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionResolver.class);
	
	private static class HandleResult {
		private String code;
		private String message;

		private HandleResult(String code, String message) {
			this.code = code;
			this.message = message;
		}
		
		public static HandleResult newInstance(String code, String message) {
			return new HandleResult(code, message);
		}
		
		public String getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

	}

	/**
	 * 针对请求处理异常
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		HandleResult result = handleException(ex);
		if (isReturnReponseBody(handler)) {
			ModelAndView modelAndView = new ModelAndView();
			//处理异常
			response.setContentType("application/json;charset=UTF-8");
			byte[] bytes = JSON.toJSONBytes(ResultVO.fail(result.getCode(),result.getMessage()), SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue);
			try {
				response.getOutputStream().write(bytes);
				response.getOutputStream().flush();
			} catch (IOException e) {
				log.error("打印错误信息出错!", e);
			}
			modelAndView.clear();
			return modelAndView;
		}else {
			Map<String, String> model = Maps.newHashMap();
			model.put("code", result.getCode());
			model.put("desc", result.getMessage());
			return new ModelAndView("500", model);
		}
	}

	/**
	 * 判断请求的是否REST接口
	 * @param handler
	 * @return
	 */
	private boolean isReturnReponseBody(Object handler) {
		HandlerMethod hm = (HandlerMethod) handler;
		if(hm.getBean().getClass().isAnnotationPresent(RestController.class)) {
			return true;
		}
		return false;
	}

	/**
	 * 处理异常
	 * @param e
	 * @return
	 */
	private HandleResult handleException(Exception e) {
		if (e instanceof BusinessException) {
			String handleResult = ((BusinessException) e).handle();
			return HandleResult.newInstance(handleResult, e.getMessage());
		} else {
			log.error("服务器发生异常了!", e);
			return HandleResult.newInstance(Constants.HttpRequestResultCode.CODE_SYSTEM_ERROR_FAIL, "服务器发生异常了,请联系管理员!");
		}
	}

}
