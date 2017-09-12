package com.kyj.common.utils;

import java.sql.Connection;

public class TransactionManager {
	
	/**
	 * 开启事务
	 * @throws Exception
	 */
	public static void openTransaction() throws Exception {
		Connection conn = ConnectionCenter.getTransactionConnection();
		if(conn != null) {
			conn.setAutoCommit(false);
		}
	}
	
	/**
	 * 提交事务
	 * @return
	 */
	public static void commit() throws Exception {
		Connection	conn = ConnectionCenter.getTransactionConnection();
		if(conn != null) {
			conn.commit();
		}
	}
	
	/**
	 * 回滚事务
	 * @return
	 */
	public static void rollback() throws Exception {
		Connection	conn = ConnectionCenter.getTransactionConnection();
		if(conn != null) {
			conn.rollback();
		}
	}
}
