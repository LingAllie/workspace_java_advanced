package com.vti.controller;

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/departments")
public class DepartmentControllerV3 {

    @Autowired
    @Qualifier("departmentServiceV3")
    private IDepartmentService service;

    @GetMapping
    public Page<Department> getAllDepartments(Pageable pageable) {
        return service.getAllDepartments(pageable);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable(name = "id") short id) {
        return service.getDepartmentByID(id);
    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable(name = "name") String name) {
        return service.getDepartmentByName(name);
    }

    @PostMapping("/create")
    public void createDepartment(@RequestBody Department department) {
        service.createDepartment(new Department(department.getName()));
    }

    @PutMapping("/update1/{id}/{name}")
    public void updateDepartment(@PathVariable(name = "id") short id, @PathVariable(name = "name") String newName) {
        service.updateDepartment(id, newName);
    }

    @PutMapping("/update2")
    public void updateDepartment(@RequestBody Department department) {
        service.updateDepartment(department);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable(name = "id") short id) {
        service.deleteDepartment(id);
    }

    @GetMapping("/checkIdExist/{id}")
    public boolean isDepartmentExistsByID(@PathVariable(name = "id") short id) {
        return service.isDepartmentExistsByID(id);
    }

    @GetMapping("/checkNameExist/{name}")
    public boolean isDepartmentExistsByName(@PathVariable(name = "name") String name) {
        return service.isDepartmentExistsByName(name);
    }
}
