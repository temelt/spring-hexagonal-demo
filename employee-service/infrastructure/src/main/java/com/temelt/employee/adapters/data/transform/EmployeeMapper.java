package com.temelt.employee.adapters.data.transform;

import com.temelt.employee.adapters.data.db.EmployeeDocument;
import com.temelt.employee.model.Employee;
import java.util.List;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
public class EmployeeMapper {

    public Employee toModel(EmployeeDocument item) {
        return Employee.builder()
                .id(item.getId())
                .lastname(item.getLastname())
                .name(item.getName())
                .startDate(item.getStartDate())
                .build();
    }

    public List<Employee> toModel(List<EmployeeDocument> items) {
        return items.stream().map(this::toModel).collect(toList());
    }
}
