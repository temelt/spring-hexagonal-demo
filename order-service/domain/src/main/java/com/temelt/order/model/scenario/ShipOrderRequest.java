package com.temelt.order.model.scenario;

import com.temelt.common.Scenario;
import lombok.Value;

@Value
public class ShipOrderRequest implements Scenario {
    String orderId;
    String shipmentRef;
    String address;
}
