package com.temelt.inventory.processor;

import com.temelt.Processor;
import com.temelt.common.ScenarioProcessor;
import com.temelt.inventory.exception.InventoryNotFoundException;
import com.temelt.inventory.model.GetInventoryByIdRequest;
import com.temelt.inventory.model.Inventory;
import com.temelt.inventory.port.InventoryPort;
import lombok.RequiredArgsConstructor;

@Processor
@RequiredArgsConstructor
class GetInventoryByIdRequestProcessor implements ScenarioProcessor<Inventory, GetInventoryByIdRequest> {
    private final InventoryPort inventoryPort;

    @Override
    public Inventory process(GetInventoryByIdRequest item) {
        return inventoryPort.getInventory(item.getId()).orElseThrow(InventoryNotFoundException::new);
    }
}
