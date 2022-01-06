package com.temel.inventory.adapters.data.transform;

import com.temel.inventory.adapters.data.db.InventoryDocument;
import com.temelt.inventory.model.Inventory;
import java.util.List;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
public class InventoryMapper {

    public Inventory toModel(InventoryDocument item) {
        return Inventory.builder()
                .id(item.getId())
                .acqDate(item.getAcqDate())
                .description(item.getDescription())
                .build();
    }

    public List<Inventory> toModel(List<InventoryDocument> items) {
        return items.stream().map(this::toModel).collect(toList());
    }
}
