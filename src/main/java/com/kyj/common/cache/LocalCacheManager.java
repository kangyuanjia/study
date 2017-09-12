package com.kyj.common.cache;

import java.util.HashMap;
import java.util.Map;

import com.kyj.common.utils.JSONUtils;

public class LocalCacheManager implements CacheService {
	private static Map<String, String> commonCache = new HashMap<String, String>();

	private static Map<String, Map<String, String>> hashCache = new HashMap<String, Map<String, String>>();

	public void set(String key, Object data, boolean setExpireTime) {
		if (hashCache.containsKey(key)) {
			hashCache.remove(key);
		}
		String value = JSONUtils.convertObject2Json(data);
		commonCache.put(key, value);
	}

	public <T> T get(String key, Class<T> clazz) {
		String value = (String) commonCache.get(key);
		return ((value == null) ? null : JSONUtils.convertJson2Object(value, clazz));
	}

	public void hashset(String key, String field, Object data, boolean setExpireTime) {
		if (commonCache.containsKey(key)) {
			commonCache.remove(key);
		}

		String value = JSONUtils.convertObject2Json(data);
		Map fieldMap = (Map) hashCache.get(key);
		if (fieldMap == null)
			fieldMap = new HashMap();
		fieldMap.put(field, value);
		hashCache.put(key, fieldMap);
	}

	public <T> T hashget(String key, String field, Class<T> clazz) {
		Map fieldMap = (Map) hashCache.get(key);
		if (fieldMap == null)
			return null;
		String value = (String) fieldMap.get(field);
		return ((value == null) ? null : JSONUtils.convertJson2Object(value, clazz));
	}

	public void remove(String key) {
		if (commonCache.containsKey(key))
			commonCache.remove(key);
		else if (hashCache.containsKey(key))
			hashCache.remove(key);
	}

	public void clear() {
		commonCache.clear();
		hashCache.clear();
	}

	public void resetExpireTime(String key) {
	}
}
