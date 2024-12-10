package com.vti.repository;

import com.vti.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalaryRepository extends JpaRepository<Salary, Integer> {

    public Salary findBySalaryName(String name);
    public boolean existsBySalaryName(String name);
}
