package com.temelt.inventory.processor;

import com.temelt.Processor;
import com.temelt.common.ScenarioProcessor;
import com.temelt.inventory.exception.InvalidDescriptionException;
import com.temelt.inventory.model.CreateInventoryRequest;
import com.temelt.inventory.model.Inventory;
import com.temelt.inventory.port.InventoryPort;
import lombok.RequiredArgsConstructor;

@Processor
@RequiredArgsConstructor
class CreateInventoryRequestProcessor implements ScenarioProcessor<Inventory, CreateInventoryRequest> {

    private final InventoryPort inventoryPort;

    @Override
    public Inventory process(CreateInventoryRequest item) {
        if (item.getDescription() == null || item.getDescription().trim().length() < 3) {
            throw new InvalidDescriptionException("inventory.create.description.invalid");
        }
        return inventoryPort.create(item);
    }
}
