package com.temelt.employee.processor;

import com.temelt.Processor;
import com.temelt.common.ScenarioProcessor;
import com.temelt.employee.model.CreateEmployeeRequest;
import com.temelt.employee.model.Employee;
import com.temelt.employee.port.EmployeePort;
import com.temelt.exception.BusinessException;
import lombok.RequiredArgsConstructor;

@Processor
@RequiredArgsConstructor
public class CreateEmployeeRequestProcessor implements ScenarioProcessor<Employee, CreateEmployeeRequest> {
    private final EmployeePort employeePort;

    @Override
    public Employee process(CreateEmployeeRequest item) {
        if (item.getName() == null || item.getName().length() < 2) {
            throw new BusinessException("Name field cannot be null or less than 2 chars!");
        }
        return employeePort.createEmployee(item);
    }
}
