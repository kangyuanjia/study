package com.kyj.common;

public class ConfigData {
	private boolean isCacheEffective;
	private String redisHost;
	private int redisPort;
	
	public boolean isCacheEffective() {
		return isCacheEffective;
	}
	public void setCacheEffective(boolean isCacheEffective) {
		this.isCacheEffective = isCacheEffective;
	}
	public String getRedisHost() {
		return redisHost;
	}
	public void setRedisHost(String redisHost) {
		this.redisHost = redisHost;
	}
	public int getRedisPort() {
		return redisPort;
	}
	public void setRedisPort(int redisPort) {
		this.redisPort = redisPort;
	}
	
	
}
