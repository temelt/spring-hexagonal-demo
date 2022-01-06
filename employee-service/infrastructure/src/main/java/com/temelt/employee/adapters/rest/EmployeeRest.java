package com.temelt.employee.adapters.rest;

import com.temelt.common.ScenarioProcessor;
import com.temelt.employee.model.CreateEmployeeRequest;
import com.temelt.employee.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeRest {
    private final ScenarioProcessor<Employee, CreateEmployeeRequest> createEmployeeRequestProcessor;

    @GetMapping("/id")
    public ResponseEntity<Employee> getEmployee(@PathVariable String id) {
        return ResponseEntity.ok(new Employee(id));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody CreateEmployeeRequest request) {
        var result = createEmployeeRequestProcessor.process(request);
        return ResponseEntity.ok(result);
    }
}
