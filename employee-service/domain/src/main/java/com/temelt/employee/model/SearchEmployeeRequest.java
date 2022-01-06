package com.temelt.employee.model;

import com.temelt.common.Scenario;
import lombok.Value;

@Value
public class SearchEmployeeRequest implements Scenario {
    String id;
}
