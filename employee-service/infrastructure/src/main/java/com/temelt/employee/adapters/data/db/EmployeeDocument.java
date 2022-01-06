package com.temelt.employee.adapters.data.db;

import java.time.LocalDate;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmployeeDocument {
    @Id
    private String id;
    private String name;
    private String lastname;
    private LocalDate startDate;
    private Boolean status;
    private Map<String, String> props;
}
