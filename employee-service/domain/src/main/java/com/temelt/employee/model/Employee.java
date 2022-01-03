package com.temelt.employee.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Employee {

    private String id;
    private String name;
    private String lastname;
    private LocalDate startDate;

    public Employee(String id) {
        this.id = id;
    }
}
