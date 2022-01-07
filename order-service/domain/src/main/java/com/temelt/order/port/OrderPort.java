package com.temelt.order.port;

import com.temelt.order.model.Order;
import com.temelt.order.model.scenario.ApproveOrderRequest;
import com.temelt.order.model.scenario.CompleteOrderRequest;
import com.temelt.order.model.scenario.CreateOrderRequest;
import com.temelt.order.model.scenario.ReturnOrderRequest;
import com.temelt.order.model.scenario.ShipOrderRequest;

public interface OrderPort {

    Order createOrder(CreateOrderRequest request);

    Order approveOrder(ApproveOrderRequest request);

    Order shipOrder(ShipOrderRequest request);

    Order completeOrder(CompleteOrderRequest request);

    Order returnOrder(ReturnOrderRequest request);

    Boolean isOrderAlreadyPlaced(CreateOrderRequest item);
}
