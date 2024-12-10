package com.vti.service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Qualifier("departmentService")
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository repository;

    @Override
    public Page<Department> getAllDepartments(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Department getDepartmentByID(short id) {
        return repository.findById((int) id).get();
    }

    @Override
    public Department getDepartmentByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void createDepartment(Department department) {
        repository.save(department);
    }

    @Override
    public void updateDepartment(short id, String newName) {
        Department updateDepartment = getDepartmentByID(id);
        updateDepartment.setName(newName);
        repository.save(updateDepartment);
    }

    @Override
    public void updateDepartment(Department department) {
        repository.save(department);
    }

    @Override
    public void deleteDepartment(short id) {
        repository.deleteById((int) id);
    }

    @Override
    public boolean isDepartmentExistsByID(short id) {
        return repository.existsById((int) id);
    }

    @Override
    public boolean isDepartmentExistsByName(String name) {
        return repository.existsByName(name);
    }
}
