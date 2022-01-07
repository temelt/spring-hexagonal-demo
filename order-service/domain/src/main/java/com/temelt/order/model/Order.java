package com.temelt.order.model;

import com.temelt.common.Scenario;
import java.time.LocalDate;
import lombok.Value;

@Value
public class Order implements Scenario {
    String employeeId;
    String inventoryId;
    LocalDate orderDate;
    OrderStatus status;
}
