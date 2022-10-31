package com.challenge.commons.exceptions;

public class AlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 401627447191774397L;

	public AlreadyExistsException(String message) {
        super(message);
    }
    
}
