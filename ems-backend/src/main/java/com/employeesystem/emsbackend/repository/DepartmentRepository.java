package com.employeesystem.emsbackend.repository;

import com.employeesystem.emsbackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Additional query methods (if needed) can be defined here
}
