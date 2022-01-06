package com.temelt.employee.exception;

import com.temelt.exception.BusinessException;

public class EmployeeNotFoundException extends BusinessException {
    public EmployeeNotFoundException() {
        super("employee.not.found");
    }
}
