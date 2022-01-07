package com.temelt.inventory.exception;

import com.temelt.exception.BusinessException;

public class InventoryNotFoundException extends BusinessException {
    public InventoryNotFoundException() {
        super("inventory.not.found");
    }
}
