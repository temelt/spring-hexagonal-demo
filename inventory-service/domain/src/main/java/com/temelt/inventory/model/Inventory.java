package com.temelt.inventory.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Inventory {
    private String id;
    private String description;
    private LocalDate acqDate;

    public Inventory(String id) {
        this.id = id;
    }
}
