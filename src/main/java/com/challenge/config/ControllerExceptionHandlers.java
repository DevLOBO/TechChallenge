package com.challenge.config;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.challenge.commons.exceptions.ContractInactiveOrNullException;
import com.challenge.commons.exceptions.AlreadyExistsException;
import com.challenge.commons.exceptions.NotFoundException;
import com.challenge.commons.ErrorMessage;

@RestControllerAdvice
public class ControllerExceptionHandlers {
@ExceptionHandler(ConstraintViolationException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException cve, WebRequest, req) {
    ErrorMessage error = new ErrorMessage();
    error.setStatus(HttpStatus.BAD_REQUEST);
    error.setMessage(cve.getMessage());
    error.setErrors(cve.getConstraintViolations().stream().map(ex -> ex.getMessage()).collect(Collectors.toList()));
    return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
}

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handleNotFoundException(NotFoundException nfe, WebRequest req) {
        ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, nfe.getMessage(), req.getDescription(false));
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleAlreadyExistsException(AlreadyExistsException aee, WebRequest req) {
        ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST, aee.getMessage(), req.getDescription(false));
        return new ResponseEntity<ErrorMessage>(error, error.getStatus());
    }
    
    @ExceptionHandler(ContractInactiveOrNullException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleContractOrNullException(ContractInactiveOrNullException cione, WebRequest req) {
    	ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST, cione.getMessage(), req.getDescription(false));
    	return new ResponseEntity<ErrorMessage>(error, error.getStatus());
    }
}
