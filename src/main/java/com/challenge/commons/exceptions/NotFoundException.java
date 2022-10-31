package com.challenge.commons.exceptions;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = -1100058332532703237L;

	public NotFoundException(String message) {
        super(message);
    }
    
}
