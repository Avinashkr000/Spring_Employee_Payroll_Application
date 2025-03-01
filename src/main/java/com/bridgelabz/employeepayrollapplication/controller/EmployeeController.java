package com.bridgelabz.employeepayrollapplication.controller;

import com.bridgelabz.employeepayrollapplication.model.Employee;
import com.bridgelabz.employeepayrollapplication.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return service.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        log.info("Fetching employee with id: {}", id);
        return service.getEmployeeById(id);
    }

    @PostMapping("/create")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        log.info("Creating new employee: {}", employee);
        return service.createEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        log.info("Updating employee with id: {}", id);
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        log.info("Deleting employee with id: {}", id);
        service.deleteEmployee(id);
    }

    // UC6: Retrieve employees by department endpoint
    @GetMapping("/department/{dept}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String dept) {
        log.info("Fetching employees from department: {}", dept);
        return service.getEmployeesByDepartment(dept);
    }
}