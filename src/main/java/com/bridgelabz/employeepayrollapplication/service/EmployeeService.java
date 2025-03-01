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

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

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

    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        repository.delete(employee);
    }

    // UC6: Retrieve employees by department
    public List<Employee> getEmployeesByDepartment(String dept) {
        return repository.findEmployeesByDepartment(dept);
    }
}