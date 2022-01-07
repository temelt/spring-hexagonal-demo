package com.temelt.order.model.scenario;

import com.temelt.common.Scenario;
import java.time.LocalDate;
import lombok.Value;

@Value
public class ApproveOrderRequest implements Scenario {
    String approvedBy;
    String orderId;
    LocalDate date;
}
