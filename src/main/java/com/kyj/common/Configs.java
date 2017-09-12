package com.kyj.common;

public class Configs {
	
	public static String dbSchema = "";
	public static String jndiName;
	
	public static int monitorScanPeriod; //参数监控线程扫描间隔
	
	public static long dataMaxLockedTime;
	
	//--------------- Redis ------------------------------
	public static String redis_host;
	public static int redis_port;
	public static int redis_maxActive;
	public static int redis_maxIdle;
	public static int redis_maxWait;
	public static long redis_minEvictableIdleTimeMillis;
	public static long redis_timeBetweenEvictionRunsMillis;
	public static boolean redis_testWhileIdle;
	public static boolean redis_testOnBorrow;
	public static boolean redis_testOnReturn;
	
	public static boolean isCacheEffective; //是否启用缓存
	
	public static String authImportTempDir;
	public static String authImportDir;
	public static String authExportDir;
	
}