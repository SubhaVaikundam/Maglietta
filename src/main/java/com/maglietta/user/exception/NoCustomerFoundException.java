package com.maglietta.user.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
/**
 * 
 * @author Subha
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoCustomerFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoCustomerFoundException(final String message) {
		super(message);
	}
}
