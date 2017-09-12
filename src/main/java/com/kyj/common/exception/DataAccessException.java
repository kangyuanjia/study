package com.kyj.common.exception;

/**
 * 数据访问异常
 * @author rong.zhu
 *
 */
public class DataAccessException extends CustomException{
	
	private static final long serialVersionUID = -4911123070393313099L;

	public DataAccessException(String msg){
		super(msg);
	}
	
	public DataAccessException(Throwable cause) {
		super(cause); 
	}

	public DataAccessException(String msg, Throwable cause){
		super(msg, cause);
	}
	
}
