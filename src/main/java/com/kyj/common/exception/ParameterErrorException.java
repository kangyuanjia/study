package com.kyj.common.exception;

/**
 * 参数错误异常
 * @author rong.zhu
 *
 */
public class ParameterErrorException extends CustomException{
	
	private static final long serialVersionUID = 4828119553849712752L;

	public ParameterErrorException(String msg){
		super(msg);
	}
	
	public ParameterErrorException(Throwable cause){
		super(cause);
	}
	
	public ParameterErrorException(String msg, Throwable cause){
		super(msg, cause);
	}
}
