package com.wordpress.m0bydig.vcm.exceptions;

public class HttpConnectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2471695807758125248L;

	public HttpConnectionException() {
		super();
	}

	public HttpConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public HttpConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public HttpConnectionException(String message) {
		super(message);
	}

	public HttpConnectionException(Throwable cause) {
		super(cause);
	}

}
