package com.vti.service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;
    
    @Override
    public List<Department> getAllDepartments(String filter, int pageNumber, int pageSize, String sort) {
        return departmentRepository.getAllDepartments(filter, pageNumber, pageSize, sort);
    }
}
