package com.challenge.commons.exceptions;

public class ContractInactiveOrNullException extends RuntimeException {
	private static final long serialVersionUID = -5247154024109469047L;

	public ContractInactiveOrNullException(String message) {
        super(message);
    }
}
