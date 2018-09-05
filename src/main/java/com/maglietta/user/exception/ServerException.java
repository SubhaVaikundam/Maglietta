package com.maglietta.user.exception;

public class ServerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServerException(final String message) {
        super(message);
    }
}
