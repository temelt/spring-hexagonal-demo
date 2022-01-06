package com.temelt.employee.processor;

import com.temelt.employee.model.CreateEmployeeRequest;
import com.temelt.employee.model.Employee;
import com.temelt.employee.port.EmployeePort;
import com.temelt.exception.BusinessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Processor : CreateEmployee")
@ExtendWith(MockitoExtension.class)
class CreateEmployeeRequestProcessorTest {

    @Mock
    private EmployeePort employeePort;

    @InjectMocks
    private CreateEmployeeRequestProcessor processor;

    @Test
    @DisplayName("Processor : CreateEmployee")
    void testCreateEmployee() {
        // given
        String name = "test-name";
        String lastname = "test-lastname";
        CreateEmployeeRequest request = new CreateEmployeeRequest(name, lastname);
        Employee emp = mock(Employee.class);
        when(employeePort.createEmployee(request)).thenReturn(emp);

        // when
        var result = processor.process(request);

        // then
        verify(employeePort).createEmployee(request);
        assertEquals(result, emp);
    }

    @Test
    @DisplayName("Processor : CreateEmployeeBusinessException")
    void testCreateEmployeeNameIsTooShort() {
        // given
        String name = "t";
        String lastname = "t";
        CreateEmployeeRequest request = new CreateEmployeeRequest(name, lastname);

        // when & then
        assertThrows(BusinessException.class, () -> processor.process(request));
    }
}
