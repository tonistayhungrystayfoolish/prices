package org.antoniogl.rest.exceptions;

import org.springframework.http.HttpStatus;

public record ApiErrorDetails(HttpStatus status, String message) {
}