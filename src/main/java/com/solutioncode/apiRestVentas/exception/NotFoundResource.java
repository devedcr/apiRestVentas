package com.solutioncode.apiRestVentas.exception;

public class NotFoundResource extends RuntimeException {
    public NotFoundResource(String message) {
        super(message);
    }

    public NotFoundResource() {
        super("Resource not found");
    }
}
