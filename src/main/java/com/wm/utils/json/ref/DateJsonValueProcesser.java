package com.wm.utils.json.ref;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateJsonValueProcesser implements JsonValueProcessor {

    private String formate;

    public DateJsonValueProcesser() {
        super();
        this.formate = "yyyy/MM/dd HH:mm:ss";
    }

    public DateJsonValueProcesser(String formate) {
        super();
        this.formate = formate;
    }

    public String getFormate() {
        return formate;
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }

    public Object processArrayValue(Object arg0, JsonConfig arg1) {
        return null;
    }

    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
        if (value instanceof Date) {
            String str = new SimpleDateFormat(this.formate).format((Date) value);
            return str;
        }
        return null;
    }

}
