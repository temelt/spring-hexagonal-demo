package com.temelt.order.exception;

import com.temelt.exception.BusinessException;

public class InventoryNotAllowedException extends BusinessException {
    public InventoryNotAllowedException(String exceptionMessageKey) {
        super(exceptionMessageKey);
    }
}
