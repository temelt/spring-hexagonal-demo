package com.temelt.inventory.processor;

import com.temelt.inventory.exception.InventoryNotFoundException;
import com.temelt.inventory.model.GetInventoryByIdRequest;
import com.temelt.inventory.model.Inventory;
import com.temelt.inventory.port.InventoryPort;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Processor : GetInventoryById")
@ExtendWith(MockitoExtension.class)
class GetInventoryByIdRequestProcessorTest {

    @Mock
    private InventoryPort inventoryPort;

    @InjectMocks
    private GetInventoryByIdRequestProcessor processor;

    @Test
    @DisplayName("Processor : GetInventoryById")
    void testProcess() {
        // given
        String id = "test-id";
        var request = new GetInventoryByIdRequest(id);
        Inventory inv = mock(Inventory.class);
        when(inventoryPort.getInventory(id)).thenReturn(Optional.of(inv));

        // when
        var result = processor.process(request);

        // then
        assertEquals(result, inv);
    }

    @Test
    @DisplayName("Processor : GetInventoryById then NotFound")
    void testProcessThenNotFound() {
        // given
        String id = "test-id";
        var request = new GetInventoryByIdRequest(id);
        when(inventoryPort.getInventory(id)).thenReturn(Optional.empty());

        // when
        var exc = assertThrows(InventoryNotFoundException.class,
                () -> processor.process(request));

        // then
        assertEquals("inventory.not.found", exc.getExceptionMessageKey());
    }
}
