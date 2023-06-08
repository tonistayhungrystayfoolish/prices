package org.antoniogl.rest.exceptions;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(String message) {
        super(message);
    }
}

