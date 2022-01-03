package com.temel.inventory.adapters.data.db;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InventoryDocument {
    @Id
    private String id;
    private String description;
    private String code;
    private LocalDate acqDate;
}
