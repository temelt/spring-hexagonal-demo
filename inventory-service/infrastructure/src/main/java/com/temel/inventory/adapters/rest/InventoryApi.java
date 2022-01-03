package com.temel.inventory.adapters.rest;

import com.temelt.inventory.model.Inventory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventory")
public class InventoryApi {

    @GetMapping("/id")
    public ResponseEntity<Inventory> getInventory(@PathVariable String id) {
        return ResponseEntity.ok(new Inventory(id));
    }
}
