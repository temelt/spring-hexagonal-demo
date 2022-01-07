package com.temelt.order.exception;

import com.temelt.exception.BusinessException;

public class InventoryNotPresentException extends BusinessException {
    public InventoryNotPresentException(String exceptionMessageKey) {
        super(exceptionMessageKey);
    }
}
