package com.temelt.inventory.model;

import com.temelt.common.Scenario;
import lombok.Value;

@Value
public class GetInventoryByIdRequest implements Scenario {
    String id;
}
