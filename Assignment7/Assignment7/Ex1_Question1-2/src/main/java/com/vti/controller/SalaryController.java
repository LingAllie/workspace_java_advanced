package com.vti.controller;

import com.vti.entity.Department;
import com.vti.entity.Salary;
import com.vti.service.IDepartmentService;
import com.vti.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/salaries")
public class SalaryController {

    @Autowired
    private ISalaryService service;

    @GetMapping
    public Page<Salary> getAllSalarys(Pageable pageable) {
        return service.getAllSalaries(pageable);
    }

    @GetMapping("/{id}")
    public Salary getSalaryById(@PathVariable(name = "id") short id) {
        return service.getSalaryByID(id);
    }

    @GetMapping("/name/{name}")
    public Salary getSalaryByName(@PathVariable(name = "name") String name) {
        return service.getSalaryByName(name);
    }

    @PostMapping("/create")
    public void createSalary(@RequestBody Salary salary) {
        service.createSalary(new Salary(salary.getSalaryName()));
    }

    @PutMapping("/update1/{id}/{name}")
    public void updateSalary(@PathVariable(name = "id") short id, @PathVariable(name = "name") String newName) {
        service.updateSalary(id, newName);
    }

    @PutMapping("/update2")
    public void updateSalary(@RequestBody Salary salary) {
        service.updateSalary(salary);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSalary(@PathVariable(name = "id") short id) {
        service.deleteSalary(id);
    }

    @GetMapping("/checkIdExist/{id}")
    public boolean isSalaryExistsByID(@PathVariable(name = "id") short id) {
        return service.isSalaryExistsByID(id);
    }

    @GetMapping("/checkNameExist/{name}")
    public boolean isSalaryExistsByName(@PathVariable(name = "name") String name) {
        return service.isSalaryExistsByName(name);
    }
}
