package com.wm.utils.http.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;

public class ContentToStringHandler extends AbstractHttpResultHandler<String> {

	@Override
	public String doHandle(HttpEntity entity) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(entity.getContent(), "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

}
