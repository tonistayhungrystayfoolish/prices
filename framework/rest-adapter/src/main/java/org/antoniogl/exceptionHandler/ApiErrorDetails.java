package org.antoniogl.exceptionHandler;

import org.springframework.http.HttpStatus;

public record ApiErrorDetails(HttpStatus status, String message) {
}