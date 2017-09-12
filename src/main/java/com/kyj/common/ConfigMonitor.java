package com.kyj.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kyj.common.ConfigData;
import com.kyj.common.cache.RedisUtils;
import com.kyj.common.utils.ConnectionCenter;

public class ConfigMonitor implements Runnable {
	private Logger logger = Logger.getLogger(ConfigMonitor.class);
	private Connection conn = null;
	private ConfigData config = null;
	private int scanPeriod;
	public ConfigMonitor(int scanPeriod) {
		config = new ConfigData();
		this.scanPeriod = scanPeriod;
	}
	
	@Override
	public void run() {
		logger.info("启动配置监控线程,扫描周期[" + scanPeriod + "]秒");
		while(true) {
			try {
				this.readConfigs();
				logger.debug("当前配置>>>>>> 是否启用缓存[" +( config.isCacheEffective()?"是":"否") + "];" +
						"redis服务器[" + config.getRedisHost() +"];redis端口[" + config.getRedisPort() +"]");
				this.monitorCacheConfig();
				this.monitorLogConfig();
				Thread.sleep(1000 * scanPeriod);
			} catch (InterruptedException e) {
				logger.error(e);
			}
		}
	}
	
	public void readConfigs() {
		conn = ConnectionCenter.getCommonConnection();
		String sql = "select PARAID,PARANAME,PARAVALUE from " + Configs.dbSchema + "AUTH_CONFIG ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String parameterId = rs.getString("PARAID");
				String parameterValue = rs.getString("PARAVALUE");
				if(parameterId.equals("auth.cache.effective")) {
					config.setCacheEffective("1".equals(parameterValue) ? true : false);
				}else if(parameterId.equals("auth.redis.host")) {
					config.setRedisHost(parameterValue);
				}else if(parameterId.equals("auth.redis.port")) {
					config.setRedisPort(Integer.valueOf(parameterValue));
				}
			}
			this.monitorCacheConfig();
		}catch(SQLException e) {
			logger.error(e);
		}finally{
			try{
				if(pstmt != null){
					pstmt.close();
					pstmt = null;
				}
				if(rs != null) {
					rs.close();
					rs = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			}catch (Exception e) {
				
			}
			
		}
	}
	
	private void monitorCacheConfig() {
		Configs.isCacheEffective = config.isCacheEffective();
		
		if(!Configs.redis_host.equals(config.getRedisHost()) || Configs.redis_port != config.getRedisPort()) {
			Configs.redis_host = config.getRedisHost();
			Configs.redis_port = config.getRedisPort();
			if(Configs.isCacheEffective) { 
				RedisUtils.resetJedisPool();// jedis配置发生变化时重置jedis连接池
			}
		}
	}
	
	private void monitorLogConfig() {
		
	}

}
