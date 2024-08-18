package com.employeesystem.emsbackend.service;

import com.employeesystem.emsbackend.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department addDepartment(Department department);
    Department findDepartmentById(Long departmentId);
    List<Department> getAllDepartments();
    Department updateDepartment(Long id, Department updatedDepartment);
    void deleteDepartmentById(Long id);
}
