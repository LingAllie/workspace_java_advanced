package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

    public Department findByDepartmentName(String name);
    public boolean existsByDepartmentName(String name);
}
