package com.vti.service;

import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentService {

    List<Department> getAllDepartments(String filter, int pageNumber, int pageSize, String sort);
}
