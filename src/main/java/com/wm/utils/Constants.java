package com.wm.utils;

public interface Constants {
	/**
	 * 页面请求结果返回代码
	 * 1：成功  0：失败
	 */
	interface HttpRequestResultCode {
		String CODE_SUCCESS = "1";
		String CODE_ERROR = "0";
		
		String CODE_BUSINESS_FAIL = "100100";
		String CODE_VALIDATE_FAIL = "100200";
		String CODE_SYSTEM_ERROR_FAIL = "100500";
	}

	/**
	 * 页面请求结果返回描述
	 * SUCCESS：操作成功  ERROR：操作失败
	 */
	interface HttpRequestResultDesc{
		String SUCCESS = "操作成功";
		String ERROR = "操作失败";
	}
}
