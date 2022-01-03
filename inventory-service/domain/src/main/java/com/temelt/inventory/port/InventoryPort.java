package com.temelt.inventory.port;

import com.temelt.inventory.model.CreateInventoryRequest;
import com.temelt.inventory.model.Inventory;
import java.util.Optional;

public interface InventoryPort {
    Optional<Inventory> getInventory(String id);

    Inventory create(CreateInventoryRequest request);
}
