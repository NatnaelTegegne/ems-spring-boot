package dev.natnaeltegegne.ems.service;

import dev.natnaeltegegne.ems.dto.EmployeeDto;
import dev.natnaeltegegne.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {

    // Always return an Entity to the controller layer unless you really need it
    Employee createEmployee(EmployeeDto employeeDto);

    Employee getEmployee(Long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Long id, EmployeeDto employeeDto);

    String deleteEmployee(Long id);
}
