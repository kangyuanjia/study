package com.kyj.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 记录当前线程的运行时信息。比如当前请求的用户ID,IP等
 * @author rong.zhu
 *
 */
public class Runtime {
	
	private static ThreadLocal<Map<String, String>> currentUserInfo = new ThreadLocal<Map<String, String>>();
	private static ThreadLocal<String> opLogId = new ThreadLocal<String>(); //用户操作日志ID
	
	public static String getCurrentUserId() {
		Map<String, String> userMap = currentUserInfo.get();
		if(userMap == null) return "";
		return userMap.get("USERID");
	}
	
	public static String getCurrentUserName() {
		Map<String, String> userMap = currentUserInfo.get();
		if(userMap == null) return "";
		return userMap.get("USERNAME");
	}
	
	public static String getCurrentUserAdmin() {
		Map<String, String> userMap = currentUserInfo.get();
		if(userMap == null) return "";
		return userMap.get("USERADMIN");
	}
	
	public static String getCurrentUserIP() {
		Map<String, String> userMap = currentUserInfo.get();
		if(userMap == null) return "";
		return userMap.get("USERIP");
	}
	
	public static String getCurrentUserOrgCode() {
		Map<String, String> userMap = currentUserInfo.get();
		if(userMap == null) return "";
		return userMap.get("ORGCODE");
	}
	
	public static void setCurrentUserInfo(String userId, String userName, String orgCode, String userAdmin, String ip) {
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("USERID", userId);
		userMap.put("USERNAME", userName);
		userMap.put("ORGCODE", orgCode);
		userMap.put("USERADMIN", userAdmin);
		userMap.put("USERIP", ip);
		currentUserInfo.set(userMap);
	}
	
	public static void clearCurrentUserInfo() {
		currentUserInfo.remove();
		opLogId.remove();
	}
	
	public static void setOPLogId(String logId) {
		opLogId.set(logId);
	}
	
	public static String getOPLogId() {
		return opLogId.get();
	}
}
