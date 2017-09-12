package com.kyj.common.exception;

public class XMLValidateException extends CustomException{

	private static final long serialVersionUID = 4146187309177600010L;

	public XMLValidateException(String msg) {
		super(msg);
	}
	
	public XMLValidateException(Throwable cause) {
		super(cause);
	}
	
	public XMLValidateException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
