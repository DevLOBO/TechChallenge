package com.challenge.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.challenge.commons.exceptions.*;
import com.challenge.commons.*;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
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

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleContractOrNullException(ContractInactiveOrNullException cione, WebRequest req) {
        ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST, cione.getMessage(), req.getDescription(false));
        return new ResponseEntity<ErrorMessage>(error, error.getStatus());
    }
}
