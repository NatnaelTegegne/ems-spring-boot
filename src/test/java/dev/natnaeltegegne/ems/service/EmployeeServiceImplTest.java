package dev.natnaeltegegne.ems.service;

import dev.natnaeltegegne.ems.exception.EmployeeNotFoundException;
import dev.natnaeltegegne.ems.repository.EmployeeRepository;
import dev.natnaeltegegne.ems.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;   // the fake

    @InjectMocks
    private EmployeeServiceImpl employeeService;      // the real thing, with the fake injected

    @Test
    void getEmployeeById_whenMissing_throwsEmployeeNotFoundException() {
        // arrange: tell the fake repo to return "nothing found"
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        // act + assert: today's behavior is that it throws
        assertThatThrownBy(() -> employeeService.getEmployee(1L))
                .isInstanceOf(EmployeeNotFoundException.class);
    }

    @Test
    void createEmployee_savesAndReturnsEmployee() {
        // ... arrange a DTO, stub employeeRepository.save(...) to return a saved entity,
        // call createEmployee, assert the returned object matches
    }
}