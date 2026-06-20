package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee= employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(EmployeeMapper.mapToEmployeeDto(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employeeService.getEmployee(id));

        return ResponseEntity.ok(employeeDto);

    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        List<EmployeeDto> employeeDtos = employees.stream()
                .map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());

        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    // Allowing the user to access the whole EmployeeDto gives them the option to update every information
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.updateEmployee(id, employeeDto);
        EmployeeDto updatedEmployeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        return ResponseEntity.ok(updatedEmployeeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        String employeeStatus = employeeService.deleteEmployee(id);

        return ResponseEntity.ok(employeeStatus);
    }
}
