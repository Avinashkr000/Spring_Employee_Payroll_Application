package com.bridgelabz.employeepayrollapplication.controller;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Employee Payroll Service!";
    }

    @GetMapping("/get/{id}")
    public String getEmployee(@PathVariable int id) {
        return "Fetching employee with ID: " + id;
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody String employee) {
        return "Employee created: " + employee;
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody String employee) {
        return "Employee updated: " + employee;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return "Employee deleted with ID: " + id;
    }
}