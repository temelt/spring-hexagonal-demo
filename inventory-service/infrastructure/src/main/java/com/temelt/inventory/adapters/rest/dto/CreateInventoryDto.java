package com.temelt.inventory.adapters.rest.dto;

import com.temelt.inventory.model.CreateInventoryRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateInventoryDto {
    private String description;

    public CreateInventoryRequest toModel() {
        return new CreateInventoryRequest(description);
    }
}
