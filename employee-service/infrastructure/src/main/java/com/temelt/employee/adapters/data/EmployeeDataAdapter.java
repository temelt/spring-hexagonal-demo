package com.temelt.employee.adapters.data;

import com.temelt.employee.adapters.data.db.EmployeeDocument;
import com.temelt.employee.adapters.data.db.EmployeeDocumentRepository;
import com.temelt.employee.adapters.data.transform.EmployeeMapper;
import com.temelt.employee.model.CreateEmployeeRequest;
import com.temelt.employee.model.Employee;
import com.temelt.employee.port.EmployeePort;
import com.temelt.provider.TimeProvider;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeDataAdapter implements EmployeePort {
    private final EmployeeDocumentRepository employeeDocumentRepository;
    private final EmployeeMapper mapper;
    private final TimeProvider timeProvider;

    @Override
    public Optional<Employee> getEmployee(String id) {
        return employeeDocumentRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public Employee createEmployee(CreateEmployeeRequest request) {
        var e = new EmployeeDocument();
        e.setName(request.getName());
        e.setLastname(request.getLastname());
        e.setStartDate(timeProvider.now());
        e.setStatus(true);
        return mapper.toModel(employeeDocumentRepository.save(e));
    }
}
