package com.kyj.common.utils;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

public class JSONUtils {
	//private static ObjectMapper mapper = new ObjectMapper();
	private static Logger log = Logger.getLogger(JSONUtils.class);

	public static String convertObj2JSONString(Object obj) {
		String s = JSON.toJSONString(obj);
		return s;
	}

	public static <T> T convertJson2Object(String content, Class<T> clazz) {
		if ((content == null) || (content.equals("")))
			return null;
		
		return JSON.parseObject(content, clazz);
	}

	public static <T> T convertDataJson2Object(String content, Class<T> valueType) {
		if ((content == null) || (content.equals("")))
			return null;

		return JSON.parseObject(content, valueType);
	}

	public static String convertObject2Json(Object obj) {
		return JSON.toJSONString(obj, true);
	}
}
