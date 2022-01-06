package com.temelt.employee.adapters.data.db;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeDocumentRepository extends MongoRepository<EmployeeDocument, String> {
}
