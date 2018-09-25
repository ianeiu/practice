package com.wm.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

public class ClobUtil {

	
	/**
	 * @Description:从Clob获取String 
	 * @author: wm
	 * @date: 2018年9月25日 上午11:49:57
	 * @version: 1.0
	 * @param clob
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public static String getStringFromClob(java.sql.Clob clob) throws SQLException, IOException {

		String reString = "";
		Reader is = clob.getCharacterStream();// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
		sb.append(s);
		s = br.readLine();
		}
		reString = sb.toString();
		return reString;
	}
}
