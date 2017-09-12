package com.kyj.common.utils;

public class C3P0DataSourceConfigData {
	
	private String driver;
	private String url;
	private String user;
	private String password;
	private int minPoolSize;
	private int maxPoolSize;
	private int initialPoolSize;
	private int maxStatements;
	private int maxIdleTime;
	private int acquireIncrement;
	private int acquireRetryAttempts;
	private int acquireRetryDelay;
	private boolean testConnectionOnCheckin;
	private int idleConnectionTestPeriod;
	private int checkoutTimeout;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMinPoolSize() {
		return minPoolSize;
	}
	public void setMinPoolSize(int minPoolSize) {
		this.minPoolSize = minPoolSize;
	}
	public int getMaxPoolSize() {
		return maxPoolSize;
	}
	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}
	public int getInitialPoolSize() {
		return initialPoolSize;
	}
	public void setInitialPoolSize(int initialPoolSize) {
		this.initialPoolSize = initialPoolSize;
	}
	public int getMaxStatements() {
		return maxStatements;
	}
	public void setMaxStatements(int maxStatements) {
		this.maxStatements = maxStatements;
	}
	public int getMaxIdleTime() {
		return maxIdleTime;
	}
	public void setMaxIdleTime(int maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
	}
	public int getAcquireIncrement() {
		return acquireIncrement;
	}
	public void setAcquireIncrement(int acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
	}
	public int getAcquireRetryAttempts() {
		return acquireRetryAttempts;
	}
	public void setAcquireRetryAttempts(int acquireRetryAttempts) {
		this.acquireRetryAttempts = acquireRetryAttempts;
	}
	public int getAcquireRetryDelay() {
		return acquireRetryDelay;
	}
	public void setAcquireRetryDelay(int acquireRetryDelay) {
		this.acquireRetryDelay = acquireRetryDelay;
	}
	public boolean isTestConnectionOnCheckin() {
		return testConnectionOnCheckin;
	}
	public void setTestConnectionOnCheckin(boolean testConnectionOnCheckin) {
		this.testConnectionOnCheckin = testConnectionOnCheckin;
	}
	public int getIdleConnectionTestPeriod() {
		return idleConnectionTestPeriod;
	}
	public void setIdleConnectionTestPeriod(int idleConnectionTestPeriod) {
		this.idleConnectionTestPeriod = idleConnectionTestPeriod;
	}
	public int getCheckoutTimeout() {
		return checkoutTimeout;
	}
	public void setCheckoutTimeout(int checkoutTimeout) {
		this.checkoutTimeout = checkoutTimeout;
	}
	
	
	
}
