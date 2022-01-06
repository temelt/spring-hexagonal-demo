package com.temelt.employee.processor;

import com.temelt.employee.exception.EmployeeNotFoundException;
import com.temelt.employee.model.Employee;
import com.temelt.employee.model.SearchEmployeeRequest;
import com.temelt.employee.port.EmployeePort;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Processor : SearchEmployee")
@ExtendWith(MockitoExtension.class)
class SearchEmployeeRequestProcessorTest {

    @Mock
    private EmployeePort employeePort;

    @InjectMocks
    private SearchEmployeeRequestProcessor processor;

    @Test
    @DisplayName("Processor : SearchEmployeeById")
    void testSearchEmployeeById() {
        // given
        String id = "test-id";
        SearchEmployeeRequest request = new SearchEmployeeRequest(id);
        Employee emp = mock(Employee.class);
        when(employeePort.getEmployee(id)).thenReturn(Optional.of(emp));

        // when
        var result = processor.process(request);

        // then
        verify(employeePort).getEmployee(id);
        assertEquals(result, emp);
    }

    @Test
    @DisplayName("Processor : SearchEmployeeByIdNotFound")
    void testSearchEmployeeByIdNotFound() {
        // given
        String id = "test-id";
        SearchEmployeeRequest request = new SearchEmployeeRequest(id);
        when(employeePort.getEmployee(id)).thenReturn(Optional.empty());

        // when && then
        assertThrows(EmployeeNotFoundException.class, () -> processor.process(request));
    }
}
