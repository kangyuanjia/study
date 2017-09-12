package com.kyj.common.exception;

import com.kyj.common.runtime.CustomErrorCode;

public class CustomRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private CustomErrorCode errorCode;

	public CustomErrorCode getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(CustomErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public CustomRuntimeException(CustomErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public CustomRuntimeException(CustomErrorCode errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}
 }
