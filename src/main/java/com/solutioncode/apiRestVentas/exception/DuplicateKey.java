package com.solutioncode.apiRestVentas.exception;

public class DuplicateKey extends RuntimeException {
    public DuplicateKey() {
        super("DuplicateKey");
    }
    public DuplicateKey(String message) {
        super(message);
    }
}
