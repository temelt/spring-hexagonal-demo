package com.temelt.employee.adapters.rest;

import com.temelt.employee.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeRest {

    @GetMapping("/id")
    public ResponseEntity<Employee> getEmployee(@PathVariable String id) {
        return ResponseEntity.ok(new Employee(id));
    }
}
