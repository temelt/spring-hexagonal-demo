package com.temelt.employee.adapters.grpc;

import com.temelt.common.ScenarioProcessor;
import com.temelt.employee.model.Employee;
import com.temelt.employee.model.SearchEmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

//TODO implement this API as a gRPC endpoint for internal communication
@Component
@RequiredArgsConstructor
public class GrpcApi {
    private final ScenarioProcessor<Employee, SearchEmployeeRequest> employeeSearchProcessor;

    public ResponseEntity<Employee> getEmployee(String id) {
        var result = employeeSearchProcessor.process(new SearchEmployeeRequest(id));
        return ResponseEntity.ok(result);
    }
}
