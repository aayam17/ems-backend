package com.employeesystem.emsbackend.controller;

import com.employeesystem.emsbackend.entity.Department;
import com.employeesystem.emsbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/dep")
@CrossOrigin(origins = "https://localhost:5173")
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department dep = departmentService.addDepartment(department);
        return new ResponseEntity<>(dep, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable("id") Long id) {
        Department dep = departmentService.findDepartmentById(id);
        return ResponseEntity.ok(dep);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @PutMapping("{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") Long id,
                                                       @RequestBody Department updatedDepartment) {
        Department dep = departmentService.updateDepartment(id, updatedDepartment);
        return ResponseEntity.ok(dep);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") Long id) {
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.ok("Department Deleted Successfully");
    }
}
