package com.temelt.exception;

public class BusinessException extends RuntimeException {
    private final String exceptionMessageKey;

    public BusinessException(String exceptionMessageKey) {
        super(exceptionMessageKey);
        this.exceptionMessageKey = exceptionMessageKey;
    }

    public String getExceptionMessageKey() {
        return exceptionMessageKey;
    }
}
