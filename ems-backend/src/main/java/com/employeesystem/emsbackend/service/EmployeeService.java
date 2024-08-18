package com.employeesystem.emsbackend.service;

import com.employeesystem.emsbackend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee findEmployeeById(Long employeeId);
    List<Employee> getAllEmployee();
    Employee updateEmployee(Long id, Employee updatedEmployee);
    void deleteEmployeeById(Long id);
    Employee findEmployeeByEmail(String email);
}
