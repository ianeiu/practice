package com.wm.ssm.common.exception;

import com.wm.utils.Constants;

public class DataValidationException extends BusinessException {

	private static final long serialVersionUID = -5308474161814489486L;

	@Override
	protected String code() {
		String code = super.code();
		return code==null ? Constants.HttpRequestResultCode.CODE_VALIDATE_FAIL:code;
	}
	
	public DataValidationException(String code, String message) {
		super(code, message);
	}
	
	public DataValidationException(String message) {
		super(DataValidationException.class.getSimpleName() + "|" + message);
	}
	
}
