package com.temelt.order.model.scenario;

import com.temelt.common.Scenario;
import lombok.Value;

@Value
public class CompleteOrderRequest implements Scenario {
    String orderId;
    String employeeId;
}
