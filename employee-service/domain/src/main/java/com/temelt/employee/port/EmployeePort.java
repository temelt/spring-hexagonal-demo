package com.temelt.employee.port;

import com.temelt.employee.model.CreateEmployeeRequest;
import com.temelt.employee.model.Employee;
import java.util.Optional;

public interface EmployeePort {

    Optional<Employee> getEmployee(String id);

    Employee createEmployee(CreateEmployeeRequest request);
}
