package com.temelt.employee.model;

import com.temelt.common.Scenario;
import javax.validation.constraints.NotNull;

public class SearchEmployeeRequest implements Scenario {
    private String id;

    public SearchEmployeeRequest(@NotNull final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
