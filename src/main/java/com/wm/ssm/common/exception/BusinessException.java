package com.wm.ssm.common.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wm.utils.Constants;
import com.wm.utils.date.DateUtil;
	

/**
 * 业务异常
 * @author FengHuayuan
 * @date 2018年1月16日 下午4:37:08.
 */
public class BusinessException extends RuntimeException {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private static final long serialVersionUID = 2624148658376402001L;

	private String code = Constants.HttpRequestResultCode.CODE_SYSTEM_ERROR_FAIL;
	private Date date;
	
	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(String code, String message) {
		super(message);
		this.code = code;
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}
	
	protected String code() {
		return code;
	}

	public String handle() {
		this.date = DateUtil.now();
		if(log.isDebugEnabled()) {
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("系统处理了业务异常[" + this.getMessage() + "],当前时间为:" + DateUtil.formatDate(date, DateUtil.DATETIME_FORMAT));
		}
		if(log.isErrorEnabled()) {
			log.error("系统处理了业务异常[" + this.getMessage() + "],当前时间为:" + DateUtil.formatDate(date, DateUtil.DATETIME_FORMAT), this);
		}
		return code();
	}
	
}
