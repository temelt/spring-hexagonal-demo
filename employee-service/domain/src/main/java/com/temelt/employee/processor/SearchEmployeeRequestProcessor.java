package com.temelt.employee.processor;

import com.temelt.Processor;
import com.temelt.common.ScenarioProcessor;
import com.temelt.employee.exception.EmployeeNotFoundException;
import com.temelt.employee.model.Employee;
import com.temelt.employee.model.SearchEmployeeRequest;
import com.temelt.employee.port.EmployeePort;
import lombok.RequiredArgsConstructor;

@Processor
@RequiredArgsConstructor
public class SearchEmployeeRequestProcessor implements ScenarioProcessor<Employee, SearchEmployeeRequest> {

    private final EmployeePort employeePort;

    @Override
    public Employee process(SearchEmployeeRequest request) {
        return employeePort.getEmployee(request.getId()).orElseThrow(EmployeeNotFoundException::new);
    }
}
