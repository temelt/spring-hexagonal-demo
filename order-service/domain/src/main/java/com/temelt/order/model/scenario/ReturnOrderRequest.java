package com.temelt.order.model.scenario;

import com.temelt.common.Scenario;
import lombok.Value;

@Value
public class ReturnOrderRequest implements Scenario {
    String orderId;
    String employeeId;
}
