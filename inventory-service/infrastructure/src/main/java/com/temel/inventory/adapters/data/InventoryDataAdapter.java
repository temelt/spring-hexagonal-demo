package com.temel.inventory.adapters.data;

import com.temel.inventory.adapters.data.db.InventoryDocument;
import com.temel.inventory.adapters.data.db.InventoryDocumentRepo;
import com.temel.inventory.adapters.data.transform.InventoryMapper;
import com.temelt.inventory.model.CreateInventoryRequest;
import com.temelt.inventory.model.Inventory;
import com.temelt.inventory.port.InventoryPort;
import com.temelt.provider.TimeProvider;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class InventoryDataAdapter implements InventoryPort {

    private final InventoryDocumentRepo inventoryDocumentRepo;
    private final InventoryMapper mapper;
    private final TimeProvider timeProvider;

    @Override
    public Optional<Inventory> getInventory(String id) {
        return inventoryDocumentRepo.findById(id).map(mapper::toModel);
    }

    @Override
    public Inventory create(CreateInventoryRequest request) {
        var i = new InventoryDocument();
        i.setDescription(request.getDescription());
        i.setAcqDate(timeProvider.now());
        return mapper.toModel(inventoryDocumentRepo.save(i));
    }
}
