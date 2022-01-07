package com.temelt.inventory.adapters.rest;

import com.temelt.inventory.adapters.rest.dto.CreateInventoryDto;
import com.temelt.common.ScenarioProcessor;
import com.temelt.inventory.model.CreateInventoryRequest;
import com.temelt.inventory.model.GetInventoryByIdRequest;
import com.temelt.inventory.model.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventory")
@RequiredArgsConstructor
public class InventoryApi {

    private final ScenarioProcessor<Inventory, GetInventoryByIdRequest> inventoryByIdProcessor;
    private final ScenarioProcessor<Inventory, CreateInventoryRequest> createInventoryProcessor;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Inventory> getInventory(@PathVariable String id) {
        var result = inventoryByIdProcessor.process(new GetInventoryByIdRequest(id));
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Inventory> create(@RequestBody CreateInventoryDto request) {
        var result = createInventoryProcessor.process(request.toModel());
        return ResponseEntity.ok(result);
    }
}
