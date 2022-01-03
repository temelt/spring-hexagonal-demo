package com.temelt.inventory.exception;

import lombok.Getter;

@Getter
public class InvalidDescriptionException extends RuntimeException {
    private final String exceptionMessageKey;

    public InvalidDescriptionException(String exceptionMessageKey) {
        super(exceptionMessageKey);
        this.exceptionMessageKey = exceptionMessageKey;
    }
}
