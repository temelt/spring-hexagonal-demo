package com.temelt.order.processor;

import com.temelt.Processor;
import com.temelt.common.ScenarioProcessor;
import com.temelt.exception.BusinessException;
import com.temelt.order.exception.InventoryNotAllowedException;
import com.temelt.order.exception.InventoryNotPresentException;
import com.temelt.order.model.Order;
import com.temelt.order.model.scenario.CreateOrderRequest;
import com.temelt.order.port.EmployeePort;
import com.temelt.order.port.InventoryPort;
import com.temelt.order.port.OrderPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Processor
@RequiredArgsConstructor
class CreateOrderRequestProcessor implements ScenarioProcessor<Order, CreateOrderRequest> {

    private final OrderPort orderPort;
    private final InventoryPort inventoryPort;
    private final EmployeePort employeePort;

    @Override
    public Order process(CreateOrderRequest item) {
        if (!employeePort.validateEmployeeAllowance(item.getEmployeeId())) {
            throw new InventoryNotAllowedException("inventory.not.allowed.for.employee");
        }

        if (!inventoryPort.inStock(item.getInventoryId())) {
            throw new InventoryNotPresentException("inventory.not.in.stock");
        }

        if (orderPort.isOrderAlreadyPlaced(item)) {
            throw new BusinessException("order.is.already.placed");
        }

        return orderPort.createOrder(item);
    }
}
