package com.temelt.employee.adapters.rest;

import com.temelt.common.ScenarioProcessor;
import com.temelt.employee.adapters.rest.dto.CreateEmployeeDto;
import com.temelt.employee.model.CreateEmployeeRequest;
import com.temelt.employee.model.Employee;
import com.temelt.employee.model.SearchEmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeRest {
    private final ScenarioProcessor<Employee, SearchEmployeeRequest> employeeSearchProcessor;
    private final ScenarioProcessor<Employee, CreateEmployeeRequest> createEmployeeProcessor;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> getEmployee(@PathVariable String id) {
        var result = employeeSearchProcessor.process(new SearchEmployeeRequest(id));
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> createEmployee(@RequestBody CreateEmployeeDto request) {
        var result = createEmployeeProcessor.process(request.toModel());
        return ResponseEntity.ok(result);
    }
}
