package com.temelt.employee.model;

import com.temelt.common.Scenario;
import lombok.Value;

@Value
public class CreateEmployeeRequest implements Scenario {
    String name;
    String lastname;
}
