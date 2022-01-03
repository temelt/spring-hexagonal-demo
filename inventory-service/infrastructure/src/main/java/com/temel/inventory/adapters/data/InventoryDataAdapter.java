package com.temel.inventory.adapters.data;

import com.temel.inventory.adapters.data.db.InventoryDocumentRepo;
import com.temelt.inventory.model.CreateInventoryRequest;
import com.temelt.inventory.model.Inventory;
import com.temelt.inventory.port.InventoryPort;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryDataAdapter implements InventoryPort {

    private final InventoryDocumentRepo inventoryDocumentRepo;

    @Override
    public Optional<Inventory> getInventory(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Inventory create(CreateInventoryRequest request) {
        return null;
    }
}
