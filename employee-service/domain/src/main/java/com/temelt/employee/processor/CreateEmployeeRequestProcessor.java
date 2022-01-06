package com.temelt.employee.processor;

import com.temelt.Processor;
import com.temelt.common.ScenarioProcessor;
import com.temelt.employee.model.CreateEmployeeRequest;
import com.temelt.employee.model.Employee;
import lombok.RequiredArgsConstructor;

@Processor
@RequiredArgsConstructor
public class CreateEmployeeRequestProcessor implements ScenarioProcessor<Employee, CreateEmployeeRequest> {
    @Override
    public Employee process(CreateEmployeeRequest item) {
        throw new UnsupportedOperationException();
    }
}
