package org.antoniogl.rest.exceptions;

import org.antoniogl.ports.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFoundException(ProductNotFoundException ex) {
        ApiErrorDetails apiErrorDetails = new ApiErrorDetails(NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(apiErrorDetails, apiErrorDetails.status());
    }
}
