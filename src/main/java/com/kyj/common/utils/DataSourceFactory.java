package com.kyj.common.utils;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**********************************************
 * 
 * 数据源管理类，支持以下数据源：<BR>
 * 
 ** JNDI数据源
 * 
 * @author Rong.Zhu
 * 
 * @Date 2013-06-27
 *
 **********************************************/
public class DataSourceFactory {
	private static Logger logger = Logger.getLogger(DataSourceFactory.class);
	
	public static DataSource getJNDIDataSource(String jndiName) throws Exception {
		DataSource ds = null;
		InitialContext ctx = new InitialContext();
		ds = (javax.sql.DataSource)ctx.lookup(jndiName);//JNDI 路径区分大小写
		logger.debug("获取JNDI数据源："+ds);
		return ds;
	}

}
