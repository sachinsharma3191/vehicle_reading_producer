package com.egen.exception;

public class VehicleServiceException extends RuntimeException {


	private static final long serialVersionUID = 5232209740995055656L;

	public VehicleServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public VehicleServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public VehicleServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public VehicleServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
