package com.temelt.inventory.processor;

import com.temelt.common.ScenarioProcessor;
import com.temelt.inventory.exception.InvalidDescriptionException;
import com.temelt.inventory.model.CreateInventoryRequest;
import com.temelt.inventory.model.Inventory;

public class InventoryCreationProcessor implements ScenarioProcessor<Inventory, CreateInventoryRequest> {

    @Override
    public Inventory process(CreateInventoryRequest item) {
        if (item.getDescription() == null || item.getDescription().trim().length() < 3) {
            throw new InvalidDescriptionException("inventory.create.description");
        }
        throw new UnsupportedOperationException();
    }
}
