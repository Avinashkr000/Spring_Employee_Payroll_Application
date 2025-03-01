package com.bridgelabz.employeepayrollapplication.service;

import com.bridgelabz.employeepayrollapplication.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapplication.model.Employee;
import com.bridgelabz.employeepayrollapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Retrieve all employees from MySQL
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Retrieve a single employee by ID; throws exception if not found
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    // Create a new employee record in the database
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Update an existing employee record; if not found, throws exception
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = getEmployeeById(id);
        employee.setName(employeeDetails.getName());
        employee.setGender(employeeDetails.getGender());
        employee.setSalary(employeeDetails.getSalary());
        employee.setStartDate(employeeDetails.getStartDate());
        employee.setNote(employeeDetails.getNote());
        employee.setProfilePic(employeeDetails.getProfilePic());
        employee.setDepartment(employeeDetails.getDepartment());
        return repository.save(employee);
    }

    // Delete an employee record after ensuring it exists
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        repository.delete(employee);
    }
}