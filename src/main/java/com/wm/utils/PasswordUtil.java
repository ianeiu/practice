package com.wm.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
	public static byte[] getMD5(byte[] src) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(src);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("系统不支持MD5", e);
		}
		return messageDigest.digest();
	}

	public static byte[] getMD5(String str) {
		return getMD5(str, "UTF-8");
	}

	public static byte[] getMD5(String str, String encode) {
		try {
			return getMD5(str.getBytes(encode));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("系统不支持编码【" + encode + "】", e);
		}
	}

	public static String getMD5Str(String str) {
		byte[] byteArray = getMD5(str);
		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
	

	/**
	 * 必选包含数字、字母、特殊字符，长度在8到15位
	 * 必选包含数字、大写字母、小写字母、特殊字符，长度在8到15位
	 */
    private static final String SEC_PASSWORD =
            "^(?=.*?[0-9])(?=.*?[a-zA-Z])(?=.*?[@!#$%^&*()_+\\.\\-\\?<>'\"|=]+).{8,15}$";
    		//"^(?=.*?[0-9])(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[@!#$%^&*()_+\\.\\-\\?<>'\"|=]+).{8,15}$";
   

    /**
     * 判断一个密码是否健壮
     * 必选包含数字、大写字母、小写字母、特殊字符，长度在8到15位
     * @param password
     * @return
     */
    public final static  boolean isSec(String password){
        return RegexUtil.isMatche(password,SEC_PASSWORD);
    }
    
}