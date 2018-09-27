package com.wm.utils;

import org.apache.commons.lang.StringUtils;

/**
 * 字符串工具类
 */
public final class StringUtil {

	public static void main(String[] args) {
		
		System.out.println(StringUtils.isBlank(" " ));
		System.out.println(StringUtils.isEmpty(" "));
	}
	
    
	/**
	 * 隐藏邮件地址前缀
	 * @param email - EMail邮箱地址 例如: ssss@koubei.com 等等...
	 * @return 返回已隐藏前缀邮件地址, 如 *********@koubei.com.
	 */
	public static String getHideEmailPrefix(String email) {
		if (null != email) {
			int index = email.lastIndexOf('@');
			if (index > 0) {
				email = repeat("*", index).concat(email.substring(index));
			}
		}
		return email;
	}
	
	/**
     * repeat - 通过源字符串重复生成N次组成新的字符串。
     *
     * @param src - 源字符串 例如: 空格(" "), 星号("*"), "g" 等等...
     * @param num - 重复生成次数
     * @return 返回已生成的重复字符串
     */
    public  static String repeat(String src, int num) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < num; i++)
            s.append(src);
        return s.toString();
    }
}