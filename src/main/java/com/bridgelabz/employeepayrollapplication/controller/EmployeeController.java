package com.bridgelabz.employeepayrollapplication.controller;
import com.bridgelabz.employeepayrollapplication.controller.EmployeeController;
import com.bridgelabz.employeepayrollapplication.service.EmployeeService;
import com.bridgelabz.employeepayrollapplication.model.Employee;
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
        log.info("Received request to fetch all employees");
        return service.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        log.debug("Fetching employee with ID: {}", id);
        return service.getEmployeeById(id);
    }

    @PostMapping("/create")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        log.info("Creating employee: {}", employee);
        return service.createEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        log.info("Updating employee with ID: {}", id);
        return service.updateEmployee(id, employee);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        log.warn("Deleting employee with ID: {}", id);
        service.deleteEmployee(id);
    }
}