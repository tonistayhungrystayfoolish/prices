package org.antoniogl.rest.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFoundException(PriceNotFoundException ex) {
        ApiErrorDetails apiErrorDetails = new ApiErrorDetails(NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(apiErrorDetails, apiErrorDetails.status());
    }
}
