package com.maglietta.user.exception;

public class CustomerCreateException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CustomerCreateException(final String message) {
		super(message);
	}
}
