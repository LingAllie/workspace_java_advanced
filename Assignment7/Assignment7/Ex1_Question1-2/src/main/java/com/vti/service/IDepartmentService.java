package com.vti.service;

import com.vti.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {

    public Page<Department> getAllDepartments(Pageable pageable);
    public Department getDepartmentByID(short id);
    public Department getDepartmentByName(String name);
    public void createDepartment(Department department);
    public void updateDepartment(short id, String newName);
    public void updateDepartment(Department department);
    public void deleteDepartment(short id);
    public boolean isDepartmentExistsByID(short id);
    public boolean isDepartmentExistsByName(String name);
}
