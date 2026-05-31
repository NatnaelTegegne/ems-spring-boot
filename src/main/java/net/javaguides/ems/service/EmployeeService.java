package net.javaguides.ems.service;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {

    // Always return an Entity to the controller layer unless you really need it
    Employee createEmployee(EmployeeDto employeeDto);

    Employee getEmployee(Long id);

    List<Employee> getAllEmployees();

    Employee updateEmploye(Long id, EmployeeDto employeeDto);
}
