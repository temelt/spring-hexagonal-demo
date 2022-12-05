package com.temelt.employee.model;

import com.temelt.common.Scenario;

public class SearchEmployeeRequest implements Scenario {
    private String id;

    public SearchEmployeeRequest(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
