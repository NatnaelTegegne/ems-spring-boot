package dev.natnaeltegegne.ems.controller;

import dev.natnaeltegegne.ems.exception.EmployeeNotFoundException;
import dev.natnaeltegegne.ems.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;             // sends fake HTTP requests

    @MockitoBean
    private EmployeeService employeeService;   // the service is faked

    @Test
    void getById_whenMissing_currentlyReturns500() throws Exception {
        when(employeeService.getEmployee(999L))
                .thenThrow(new EmployeeNotFoundException("Employee not found."));

        mockMvc.perform(get("/api/employee/1"))
                .andExpect(status().isInternalServerError());   // 500, today's WRONG behavior
    }
}