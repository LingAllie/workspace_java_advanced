package com.vti.service;

import com.vti.entity.Department;
import com.vti.repository.IDCustomQueryMethodName;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Qualifier("departmentServiceV2")
public class DepartmentServiceV2 implements IDepartmentService {

    @Autowired
    private IDCustomQueryMethodName repository;

    @Override
    public Page<Department> getAllDepartments(Pageable pageable) {
        return repository.findAllDepartments(pageable);
    }

    @Override
    public Department getDepartmentByID(short id) {
        return repository.findDepartmentById(id);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return repository.findDepartmentByName(name);
    }

    @Override
    public void createDepartment(Department department) {
        repository.createNewDepartment(department.getName());
    }

    @Override
    public void updateDepartment(short id, String newName) {
        repository.updateDepartmentName(id, newName);
    }

    @Override
    public void updateDepartment(Department department) {
        repository.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(short id) {
        repository.deleteById(id);
    }

    @Override
    public boolean isDepartmentExistsByID(short id) {
        return repository.existsDepartmentById(id);
    }

    @Override
    public boolean isDepartmentExistsByName(String name) {
        return repository.existsDepartmentByName(name);
    }
}
