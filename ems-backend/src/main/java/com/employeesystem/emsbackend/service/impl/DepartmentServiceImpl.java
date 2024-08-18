package com.employeesystem.emsbackend.service.impl;

import com.employeesystem.emsbackend.entity.Department;
import com.employeesystem.emsbackend.exception.ResourceNotFoundException;
import com.employeesystem.emsbackend.repository.DepartmentRepository;
import com.employeesystem.emsbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department Id " + departmentId + " not found"));
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Long id, Department updatedDepartment) {
        Department dept = findDepartmentById(id);
        dept.setName(updatedDepartment.getName());
        dept.setDescription(updatedDepartment.getDescription());
        return departmentRepository.save(dept);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        boolean exists = departmentRepository.existsById(id);
        if (!exists) {
            throw new ResourceNotFoundException("Department not found with Id " + id);
        }
        departmentRepository.deleteById(id);
    }
}
