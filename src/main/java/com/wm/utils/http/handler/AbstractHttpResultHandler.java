package com.wm.utils.http.handler;

import org.apache.http.HttpEntity;

public abstract class AbstractHttpResultHandler<T> {

	public abstract T doHandle(HttpEntity entity) throws Exception;
	
}
