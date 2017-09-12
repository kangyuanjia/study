package com.kyj.common.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.kyj.common.Configs;

public class ConnectionCenter {
	
	private static Logger logger = Logger.getLogger(ConnectionCenter.class);
	
	/** 通过ThreadLocal保存事务型连接*/
	private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();
	
	public static String datasourceType = null;
	
	public static String dbConfig = null;
	
	/**
	 * 获取普通连接，用于执行数据库查询等非事务性操作。执行完毕后需要立即关闭/释放
	 * @return
	 * @throws Exception
	 */
	public static Connection getCommonConnection(){
		Connection commonConn = null;
		try{
			DataSource ds = DataSourceFactory.getJNDIDataSource(Configs.jndiName);
			if(ds != null) {
				commonConn = ds.getConnection();		
			}
		}catch(Exception e) {
			logger.error("获取连接错误", e);
		}
		
		return commonConn;
	}
	
	/**
	 * 获取事务型连接，用于执行事务性操作。
	 * @return
	 * @throws Exception
	 */
	public static Connection getTransactionConnection() {
		Connection transConn = connContainer.get();
		try{
			if(transConn == null){
				DataSource ds = DataSourceFactory.getJNDIDataSource(Configs.jndiName);
				if(ds != null) {
					transConn = ds.getConnection();
					transConn.setAutoCommit(false);
					connContainer.set(transConn);
				}
			}
		}catch(Exception e) {
			logger.error("获取连接错误", e);
		}
		
		return transConn;
	}
	
	/**
	 * 关闭/释放 普通连接
	 * @param conn
	 */
	public static void closeCommonConnectin(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
//				conn = null;
			} catch (SQLException e) {
				logger.error("关闭连接错误", e);
			}
			
		}
	}
	
	/**
	 * 关闭/释放  事务性连接
	 */
	public static void closeTransactionConnection() {
		Connection transConn = connContainer.get();
		if(transConn != null) {
			connContainer.remove();
			try {
				transConn.setAutoCommit(true);//还原连接为自动提交
				transConn.close();
//				transConn = null;
			} catch (SQLException e) {
				logger.error("关闭连接错误", e);
			}
		}
	}
	
}
