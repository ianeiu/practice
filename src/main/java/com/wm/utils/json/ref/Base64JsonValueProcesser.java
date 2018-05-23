package com.wm.utils.json.ref;

import java.io.File;
import java.io.InputStream;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base64JsonValueProcesser implements JsonValueProcessor {
	static transient final Logger log = LoggerFactory.getLogger(Base64JsonValueProcesser.class);

    public Base64JsonValueProcesser() {
        super();

    }


    public Object processArrayValue(Object arg0, JsonConfig arg1) {
        return null;
    }

    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        if (value instanceof File) {
        	try{
        		return Base64.encodeBase64String(FileUtils.readFileToByteArray((File)value));
        	}catch(Exception e){
        		log.warn("未能读取文件"+value);
        	}
            
        }
        if (value instanceof InputStream) {
        	try{
        		return Base64.encodeBase64String(IOUtils.toByteArray((InputStream)value));
        	}catch(Exception e){
        		log.warn("未能读取字节流");
        	}
            
        }
        return null;
    }

}
