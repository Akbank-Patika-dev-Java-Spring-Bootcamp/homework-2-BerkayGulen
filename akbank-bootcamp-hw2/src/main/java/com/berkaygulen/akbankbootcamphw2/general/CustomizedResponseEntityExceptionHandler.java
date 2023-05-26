package com.berkaygulen.akbankbootcamphw2.general;

import jakarta.validation.ConstraintViolationException;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest webRequest) {
        ConstraintViolationException constraintViolationException = (ConstraintViolationException) e.getCause().getCause();
        String errorMessage = new ArrayList<>(constraintViolationException.getConstraintViolations()).get(0).getMessage();


        String message = e.getMessage();
        String description = webRequest.getDescription(false);
        var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
        var response = RestResponse.error(genericErrorMessage);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(BusinessException e, WebRequest webRequest) {

        String message = e.getBaseErrorMessage().getMessage();
        String description = webRequest.getDescription(false);

        var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
        var response = RestResponse.error(genericErrorMessage);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(NotFoundException e, WebRequest webRequest) {

        String message = e.getBaseErrorMessage().getMessage();
        String description = webRequest.getDescription(false);

        var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
        var response = RestResponse.error(genericErrorMessage);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(TransactionSystemException e, WebRequest webRequest) {
        ConstraintViolationException constraintViolationException = (ConstraintViolationException) e.getCause().getCause();
        String errorMessage = new ArrayList<>(constraintViolationException.getConstraintViolations()).get(0).getMessage();

        String message = errorMessage;
        String description = webRequest.getDescription(false);
        var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
        var response = RestResponse.error(genericErrorMessage);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(DataIntegrityViolationException e, WebRequest webRequest) {
        String message = e.getCause().getCause().getMessage();
        String description = webRequest.getDescription(false);
        var genericErrorMessage = new GenericErrorMessage(LocalDateTime.now(), message, description);
        var response = RestResponse.error(genericErrorMessage);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



