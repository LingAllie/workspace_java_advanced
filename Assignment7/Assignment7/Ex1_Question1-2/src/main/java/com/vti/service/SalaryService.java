package com.vti.service;

import com.vti.entity.Salary;
import com.vti.repository.ISalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SalaryService implements ISalaryService {

    @Autowired
    private ISalaryRepository repository;

    @Override
    public Page<Salary> getAllSalaries(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Salary getSalaryByID(short id) {
        return repository.findById((int) id).get();
    }

    @Override
    public Salary getSalaryByName(String name) {
        return repository.findBySalaryName(name);
    }

    @Override
    public void createSalary(Salary salary) {
        repository.save(salary);
    }

    @Override
    public void updateSalary(short id, String newName) {
        Salary updateSalary= getSalaryByID(id);
        Salary.SalaryName name = newName.equalsIgnoreCase("dev") ? Salary.SalaryName.DEV
                : newName.equalsIgnoreCase("test") ? Salary.SalaryName.TEST
                : newName.equalsIgnoreCase("scrummaster") ? Salary.SalaryName.SCRUMMASTER
                : Salary.SalaryName.PM;
        updateSalary.setSalaryName(name);
        repository.save(updateSalary);
    }

    @Override
    public void updateSalary(Salary salary) {
        repository.save(salary);
    }

    @Override
    public void deleteSalary(short id) {
        repository.deleteById((int) id);
    }

    @Override
    public boolean isSalaryExistsByID(short id) {
        return repository.existsById((int) id);
    }

    @Override
    public boolean isSalaryExistsByName(String name) {
        return repository.existsBySalaryName(name);
    }
}
