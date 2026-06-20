package net.javaguides.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.EmployeeNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found."));

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();

    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found."));
        employee.setFirstName(employeeDto.firstName());
        employee.setLastName(employeeDto.lastName());
        employee.setEmail(employeeDto.email());

        //save back to the db
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public String deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found."));

        employeeRepository.delete(employee);
        return "Employee successfully deleted.";
    }

}
