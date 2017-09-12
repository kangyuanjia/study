package com.kyj.common.exception;

/** 
 * <p>Title: CustomException </p> 
 * <p>Description:系统 自定义异常类，针对预期的异常，需要在程序中抛出此类的异常</p> 
 * @author kangyuanjia 
 * @date 2016年4月7日 下午4:09:56 
 */ 
public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;
	//异常信息
	public String message;
	
	public CustomException(String message){
		super(message);
		this.message = message;
	}

	public CustomException(Throwable cause) {
		super(cause);
	}
	
	public CustomException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.getMessage()).append("; ");
		if(this.getCause() != null) {
			sb.append("nested exception is ").append(this.getCause());
		}
		return sb.toString();
	}
	
	public String getLocalizedMessage() {
		return super.getMessage();
	}
	

}
