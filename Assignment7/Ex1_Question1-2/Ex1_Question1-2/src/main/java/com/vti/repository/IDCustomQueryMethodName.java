package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IDCustomQueryMethodName extends JpaRepository<Department, Integer> {

    @Query("FROM Department d")
    Page<Department> findAllDepartments(Pageable pageable);

    Department findDepartmentById(short id);

    Department findDepartmentByName(String name);

    @Modifying
    @Transactional
    @Query("INSERT INTO Department (name) VALUES (?1)")
    void createNewDepartment(String name);

    @Modifying
    @Transactional
    @Query("UPDATE Department d SET d.name = ?2 WHERE d.id = ?1")
    void updateDepartmentName(short id, String newName);

    @Modifying
    @Transactional
    @Query("UPDATE Department d SET d.name = :#{#department.name} WHERE d.id = :#{#department.id}")
    void updateDepartment(@Param("department") Department department);

    @Transactional
    void deleteById(short id);

    boolean existsDepartmentById(short id);

    boolean existsDepartmentByName(String name);
}
