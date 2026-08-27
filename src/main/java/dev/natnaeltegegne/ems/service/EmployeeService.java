package dev.natnaeltegegne.ems.service;

import dev.natnaeltegegne.ems.dto.EmployeeDto;


import java.util.List;

public interface EmployeeService {

    // Always return an DTO to the controller layer unless you really need it
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployee(Long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    String deleteEmployee(Long id);
}
