package com.kyj.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * Web请求参数JSON解析
 * 
 */
public class WebUtil {

	public static JSONObject processJSONRequest(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
			return JSONObject.parseObject(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String processSrtingRequest(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			InputStream inStream = request.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "UTF-8")); 
			while ((line = reader.readLine()) != null) {
				String valueDecoded = java.net.URLDecoder.decode(line,"UTF-8");
				json.append(valueDecoded);
			}
			return json.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static EditMode toMode(String mode) {
		if ("update".equalsIgnoreCase(mode)) {
			return EditMode.UPDATE;
		} else if ("delete".equalsIgnoreCase(mode)) {
			return EditMode.DELETE;
		} else if ("display".equalsIgnoreCase(mode)) {
			return EditMode.DISPLAY;
		}  else if ("add".equalsIgnoreCase(mode)) {
			return EditMode.ADD;
		} else {
			return null;
		}
	}

	/**
	 * 将map转换为json string
	 * 
	 * @param map
	 * @return
	 */
	public static String changeMapToJsonString(Map<String, Object> map) {
		JSONObject.toJSONString(map);
		return JSONObject.toJSONString(map);
	}

	public static String changeMapToString(Map<String, Object> paramMap) {
		Set<Entry<String, Object>> entrySet = paramMap.entrySet();
		StringBuilder params = new StringBuilder("");
		for (Entry<String, Object> entry : entrySet) {
			params.append(entry.getKey());
			params.append("=");
			params.append(entry.getValue().toString());
			params.append("&");
		}
		return params.toString().substring(0, params.toString().length() - 1);
	}

	/**
	 * @Title: changeJsonStringToMap
	 * @Description: 将json数据转换为Map对象
	 * @param @param json
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 */
	public static Map<String, Object> changeJsonStringToMap(String json) {
		Map<String, Object> obj = (Map<String, Object>) JSONObject.parse(json);
		return obj;
	}
	
	public static Map<String, String> changeStringToMap(String json) {
		Map<String, String> obj = (Map<String, String>) JSONObject.parse(json);
		return obj;
	}
	
	/**
	 * @Title: changeObjectToJsonString
	 * @Description: 将java 对象转换为json 字符串
	 * @param @param obj
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String changeObjectToJsonString(Object obj) {
		return JSONObject.toJSONString(obj);
	}

	/**
	 * jsonObject change map,
	 */

	public static Map<String, String> jsonObjectToMap(JSONObject jsonObject) {

		Map<String, String> result = new HashMap<String, String>();
		@SuppressWarnings("unchecked")
		Set<String> keySet = jsonObject.keySet();
		String value = null;
		for(String key : keySet){
			value = jsonObject.getString(key);
			result.put(key, value);
		}
		return result;
	}

	/**
	 * 获取web-inf 的路径
	 * 
	 * @return
	 */
	public static String getRoobot() {

		String classPath = WebUtil.class.getClassLoader().getResource("/").getPath();
		String rootPath = "";
		// windows下
		if ("\\".equals(File.separator)) {
			rootPath = classPath.substring(1, classPath.indexOf("classes"));
			rootPath = rootPath.replace("/", "\\");
		}
		// linux下
		if ("/".equals(File.separator)) {
			rootPath = classPath.substring(0, classPath.indexOf("classes"));
			rootPath = rootPath.replace("\\", "/");
		}
		try {
			rootPath = java.net.URLDecoder.decode(rootPath, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return rootPath;
	}

	// mapToObject,ObjectToMap
	/**
	 * 将obj 转换为map对象
	 * 
	 * @param obj
	 * @return
	 */
	public static Map<String, String> objectToMap(Object obj) {
		Map<String, String> result = new HashMap<String, String>();
		Method[] methods = obj.getClass().getDeclaredMethods();
		// Field[] fields = obj.getClass().getDeclaredFields();
		for (Method method : methods) {
			try {
				if (method.getName().startsWith("get")) {
					String field = method.getName();
					field = field.substring(field.indexOf("get") + 3);
					field = field.toLowerCase().charAt(0) + field.substring(1);

					Object value = method.invoke(obj, (Object[]) null);
					result.put(field, null == value ? "" : value.toString());
				}
			} catch (Exception e) {
			}
		}

		return result;
	}

	/**
	 * 将map转换成Javabean
	 * 
	 * @param obj
	 *            javaBean
	 * @param data
	 *            map数据
	 */
	public static Object mapToObject(Object obj, Map<String, String> data) {
		Method[] methods = obj.getClass().getDeclaredMethods();
		for (Method method : methods) {
			try {
				if (method.getName().startsWith("set")) {
					String field = method.getName();
					field = field.substring(field.indexOf("set") + 3);
					field = field.toLowerCase().charAt(0) + field.substring(1);
					method.invoke(obj, new Object[] { data.get(field) });
				}
			} catch (Exception e) {
			}
		}
		return obj;
	}

	/**
	 * 将obj转换成 Map
	 * 
	 * @param obj
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Map<String, Object> object2MapWithoutNull(Object obj) {
		// throws IllegalArgumentException, IllegalAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = obj.getClass().getDeclaredFields();
		for (int j = 0; j < fields.length; j++) {
			fields[j].setAccessible(true);// 设置这个变量不进行访问权限检查 在类里设置的变量可以为private
			try {
				if (fields[j].get(obj) != null) {
					map.put(fields[j].getName(), fields[j].get(obj).toString());
				}
				map.put(fields[j].getName(), fields[j].get(obj));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {

	}

}
