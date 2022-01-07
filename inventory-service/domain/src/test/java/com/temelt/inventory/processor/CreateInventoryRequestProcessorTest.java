package com.temelt.inventory.processor;

import com.temelt.inventory.exception.InvalidDescriptionException;
import com.temelt.inventory.model.CreateInventoryRequest;
import com.temelt.inventory.model.Inventory;
import com.temelt.inventory.port.InventoryPort;
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

@DisplayName("Processor : CreateInventory")
@ExtendWith(MockitoExtension.class)
class CreateInventoryRequestProcessorTest {
    @Mock
    private InventoryPort inventoryPort;

    @InjectMocks
    private CreateInventoryRequestProcessor processor;

    @Test
    @DisplayName("Processor : CreateInventory")
    void testProcess() {
        // given
        String description = "test-description";
        var request = new CreateInventoryRequest(description);
        Inventory inv = mock(Inventory.class);
        when(inv.getDescription()).thenReturn(description);
        when(inventoryPort.create(request)).thenReturn(inv);

        // when
        var result = processor.process(request);

        // then
        assertEquals(result.getDescription(), description);
    }

    @Test
    @DisplayName("Processor : CreateInventory then exception")
    void testProcessThenException() {
        // given
        String description = "t";
        var request = new CreateInventoryRequest(description);

        // when && then
        var exc = assertThrows(InvalidDescriptionException.class,
                () -> processor.process(request));
        assertEquals("inventory.create.description.invalid", exc.getExceptionMessageKey());
    }
}
