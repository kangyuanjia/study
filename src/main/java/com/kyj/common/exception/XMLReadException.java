package com.kyj.common.exception;

public class XMLReadException extends CustomException {
	
	private static final long serialVersionUID = -3356468601967079137L;

	public XMLReadException(String msg) {
		super(msg);
	}
	
	public XMLReadException(Throwable cause) {
		super(cause);
	}
	
	public XMLReadException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
