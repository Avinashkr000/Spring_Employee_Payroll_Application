package com.bridgelabz.employeepayrollapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping
    public String testEndpoint() {
        return "Welcome to Employee Payroll App";
    }
}