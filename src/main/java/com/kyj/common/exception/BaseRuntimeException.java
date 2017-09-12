package com.kyj.common.exception;

public abstract class BaseRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 431521612973899595L;
	private int errorCode = 0;

	public int getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public BaseRuntimeException(String msg) {
		super(msg);
	}

	public BaseRuntimeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public String getMessage() {
		return ExceptionUtils.buildMessage(super.getMessage(), getCause());
	}

	public Throwable getRootCause() {
		Throwable rootCause = null;
		Throwable cause = getCause();
		while ((cause != null) && (cause != rootCause)) {
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}

	public Throwable getMostSpecificCause() {
		Throwable rootCause = getRootCause();
		return ((rootCause != null) ? rootCause : this);
	}

	public boolean contains(Class<?> exType) {
		if (exType == null) {
			return false;
		}
		if (exType.isInstance(this)) {
			return true;
		}
		Throwable cause = getCause();
		if (cause == this) {
			return false;
		}
		if (cause instanceof BaseRuntimeException) {
			return ((BaseRuntimeException) cause).contains(exType);
		}

		while (cause != null) {
			if (exType.isInstance(cause)) {
				return true;
			}
			if (cause.getCause() == cause) {
				break;
			}
			cause = cause.getCause();
		}
		return false;
	}

	static {
		ExceptionUtils.class.getName();
	}
}
