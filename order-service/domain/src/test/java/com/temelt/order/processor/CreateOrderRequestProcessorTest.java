package com.temelt.order.processor;

import com.temelt.exception.BusinessException;
import com.temelt.order.exception.InventoryNotAllowedException;
import com.temelt.order.exception.InventoryNotPresentException;
import com.temelt.order.model.Order;
import com.temelt.order.model.OrderStatus;
import com.temelt.order.model.scenario.CreateOrderRequest;
import com.temelt.order.port.EmployeePort;
import com.temelt.order.port.InventoryPort;
import com.temelt.order.port.OrderPort;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@DisplayName("Processor : CreateOrder")
@ExtendWith(MockitoExtension.class)
class CreateOrderRequestProcessorTest {
    @Mock
    private OrderPort orderPort;
    @Mock
    private InventoryPort inventoryPort;
    @Mock
    private EmployeePort employeePort;

    @InjectMocks
    private CreateOrderRequestProcessor processor;

    @Test
    void testProcess() {
        // given
        String invId = "test-inv-id";
        String empId = "test-emp-id";
        var request = new CreateOrderRequest(invId, empId);
        Order order = new Order(empId, invId, LocalDate.now(), OrderStatus.REQUEST);
        when(orderPort.createOrder(request)).thenReturn(order);
        when(employeePort.validateEmployeeAllowance(empId)).thenReturn(true);
        when(inventoryPort.inStock(invId)).thenReturn(true);
        when(orderPort.isOrderAlreadyPlaced(request)).thenReturn(false);

        // when
        var result = processor.process(request);

        // then
        assertEquals(result.getEmployeeId(), order.getEmployeeId());
        assertEquals(OrderStatus.REQUEST, result.getStatus());
        assertEquals(result.getInventoryId(), order.getInventoryId());
    }

    @Test
    void testProcessThenNotPresent() {
        // given
        String invId = "test-inv-id";
        String empId = "test-emp-id";
        var request = new CreateOrderRequest(invId, empId);
        Order order = new Order(empId, invId, LocalDate.now(), OrderStatus.REQUEST);
        when(employeePort.validateEmployeeAllowance(empId)).thenReturn(true);

        // when
        var result = assertThrows(InventoryNotPresentException.class,
                () -> processor.process(request));

        // then
        assertEquals("inventory.not.in.stock", result.getExceptionMessageKey());
    }

    @Test
    void testProcessThenNotAllowed() {
        // given
        String invId = "test-inv-id";
        String empId = "test-emp-id";
        var request = new CreateOrderRequest(invId, empId);
        Order order = new Order(empId, invId, LocalDate.now(), OrderStatus.REQUEST);

        // when
        var result = assertThrows(InventoryNotAllowedException.class,
                () -> processor.process(request));

        // then
        assertEquals("inventory.not.allowed.for.employee", result.getExceptionMessageKey());
    }

    @Test
    void testProcessThenAlreadyPlaced() {
        // given
        String invId = "test-inv-id";
        String empId = "test-emp-id";
        var request = new CreateOrderRequest(invId, empId);
        Order order = new Order(empId, invId, LocalDate.now(), OrderStatus.REQUEST);
        when(employeePort.validateEmployeeAllowance(empId)).thenReturn(true);
        when(inventoryPort.inStock(invId)).thenReturn(true);
        when(orderPort.isOrderAlreadyPlaced(request)).thenReturn(true);

        // when
        var result = assertThrows(BusinessException.class,
                () -> processor.process(request));

        // then
        assertEquals("order.is.already.placed", result.getExceptionMessageKey());
    }
}
