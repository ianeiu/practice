package com.wm.ssm.common.vo;

/**
 * 封装json对象，所有返回结果都使用它
 */
public class Result<T> {

	private String code;
	private String desc;

	private T data;// 成功时返回的数据

	public Result(String code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
	}
	

	public Result(String code, String desc, T data) {
		super();
		this.code = code;
		this.desc = desc;
		this.data = data;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


}
