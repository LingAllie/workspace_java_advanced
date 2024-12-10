package com.vti.service;

import com.vti.entity.Salary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISalaryService {

    public Page<Salary> getAllSalaries(Pageable pageable);
    public Salary getSalaryByID(short id);
    public Salary getSalaryByName(String name);
    public void createSalary(Salary salary);
    public void updateSalary(short id, String newName);
    public void updateSalary(Salary salary);
    public void deleteSalary(short id);
    public boolean isSalaryExistsByID(short id);
    public boolean isSalaryExistsByName(String name);
}
