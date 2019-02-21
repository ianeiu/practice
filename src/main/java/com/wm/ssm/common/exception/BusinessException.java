package com.wm.ssm.common.exception;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
	

/**
 * 业务异常
 * @author FengHuayuan
 * @date 2018年1月16日 下午4:37:08.
 */
public class BusinessException extends RuntimeException {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private static final long serialVersionUID = 2624148658376402001L;

	private String code = "100500";
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
		this.date = now();
		if(log.isDebugEnabled()) {
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("系统处理了业务异常[" + this.getMessage() + "],当前时间为:" + formatDate(date, DATETIME_FORMAT));
		}
		if(log.isErrorEnabled()) {
			log.error("系统处理了业务异常[" + this.getMessage() + "],当前时间为:" + formatDate(date, DATETIME_FORMAT), this);
		}
		return code();
	}
	

	public static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static Date now() {
		Calendar now = Calendar.getInstance();
		return now.getTime();
	}
	public static String formatDate(Date date, String format) {
		if (date == null) {
			return "";
		}
		if (format.indexOf("h") > 0) {
			format = format.replace('h', 'H');
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}
}
