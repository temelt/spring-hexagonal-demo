package com.temelt.employee.adapters.rest.dto;

import com.temelt.employee.model.CreateEmployeeRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeDto {
    private String name;
    private String lastname;

    public CreateEmployeeRequest toModel() {
        return new CreateEmployeeRequest(this.name, this.lastname);
    }
}
