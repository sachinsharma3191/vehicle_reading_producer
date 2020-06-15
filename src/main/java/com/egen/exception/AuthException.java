package com.egen.exception;

public class AuthException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuthException() {

	}

	public AuthException(String message) {
		super(message);

	}

	public AuthException(Throwable cause) {
		super(cause);

	}

	public AuthException(String message, Throwable cause) {
		super(message, cause);

	}

	public AuthException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
