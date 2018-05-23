package com.wm.utils.json.ref;

import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class DateTimeJsonValueProcesser implements JsonValueProcessor {


    public Object processArrayValue(Object arg0, JsonConfig arg1) {
        return null;
    }

    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        if (value instanceof Date) {
            Long str = ((Date) value).getTime();
            return str;
        }
        return null;
    }

}
