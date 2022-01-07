package com.temelt.order.model.scenario;

import com.temelt.common.Scenario;
import lombok.Value;

@Value
public class CreateOrderRequest implements Scenario {
    String inventoryId;
    String employeeId;
}
