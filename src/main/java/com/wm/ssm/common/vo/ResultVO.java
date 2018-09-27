package com.wm.ssm.common.vo;

import com.wm.utils.Constants;

import lombok.Data;

/**
 * @author admin619
 */
//@ApiModel(value = "Result", description = "通用返回对象")
@Data
public class ResultVO<T> {
	/**
	 * 1:成功,其它,失败
	 */
	//@ApiModelProperty(value="返回码:1-成功,其它-失败",required = true)
	private String code;
	/**
	 * 结果描述
	 */
	//@ApiModelProperty(value="结果描述",required = false)
	private String desc;
	//@ApiModelProperty(value="返回数据体",required = false)
	private T data;

	/**
	 * 将构造器设定为私有方法
	 * 强制使用者通过工厂方法获取对应的ResultVO
	 */
	private ResultVO(String code,String desc,T data){
		this.code = code;
		this.desc = desc;
		this.data = data;
	}

	public static <T> ResultVO<T> createBySuccess(){
		return new ResultVO<T>(Constants.HttpRequestResultCode.CODE_SUCCESS,Constants.HttpRequestResultDesc.SUCCESS,null);
	}

	public static <T> ResultVO<T> createBySuccess(String desc){
		return new ResultVO<T>(Constants.HttpRequestResultCode.CODE_SUCCESS,desc,null);
	}

	public static <T> ResultVO<T> createBySuccess(T data){
		return new ResultVO<T>(Constants.HttpRequestResultCode.CODE_SUCCESS,Constants.HttpRequestResultDesc.SUCCESS,data);
	}

	public static <T> ResultVO<T> createByError(){
		return new ResultVO<T>(Constants.HttpRequestResultCode.CODE_ERROR,Constants.HttpRequestResultDesc.ERROR,null);
	}

	public static <T> ResultVO<T> createByError(String desc){
		return new ResultVO<T>(Constants.HttpRequestResultCode.CODE_ERROR,desc,null);
	}

	public static <T> ResultVO<T> createByError(T data){
		return new ResultVO<T>(Constants.HttpRequestResultCode.CODE_ERROR,Constants.HttpRequestResultDesc.ERROR,data);
	}

	public static <T> ResultVO<T> fail(String code,String desc){
		return new ResultVO<T>(code,desc,null);
	}


}
