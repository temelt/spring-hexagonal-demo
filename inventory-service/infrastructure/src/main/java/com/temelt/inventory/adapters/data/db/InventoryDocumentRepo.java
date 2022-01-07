package com.temelt.inventory.adapters.data.db;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryDocumentRepo extends MongoRepository<InventoryDocument, String> {
}
