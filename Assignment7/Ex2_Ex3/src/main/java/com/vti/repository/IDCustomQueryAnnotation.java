package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IDCustomQueryAnnotation extends JpaRepository<Department, Integer> {
    @Query("FROM Department d")
    Page<Department> findAllDepartments(Pageable pageable);

    @Query("FROM Department d WHERE d.id = ?1")
    Department findDepartmentById(short id);

    @Query("FROM Department d WHERE d.name = ?1")
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

    @Modifying
    @Transactional
    @Query("DELETE FROM Department d WHERE d.id = ?1")
    void deleteDepartmentById(short id);

    @Query("SELECT COUNT(d) > 0 FROM Department d WHERE d.id = ?1")
    boolean existsDepartmentById(short id);

    @Query("SELECT COUNT(d) > 0 FROM Department d WHERE d.name = ?1")
    boolean existsDepartmentByName(String name);
}
