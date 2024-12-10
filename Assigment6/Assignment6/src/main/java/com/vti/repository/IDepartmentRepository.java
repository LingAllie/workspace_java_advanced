package com.vti.repository;

import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentRepository {

    List<Department> getAllDepartments(String filter, int pageNumber, int pageSize, String sort);
}
