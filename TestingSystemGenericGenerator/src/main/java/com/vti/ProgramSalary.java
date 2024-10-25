package com.vti;

import java.util.List;

import com.vti.entity.Salary;
import com.vti.repository.SalaryRepository;

public class ProgramSalary {
	public static void main(String[] args) {
		SalaryRepository repository = new SalaryRepository();

		System.out.println("***********GET ALL SALARIES***********");

		List<Salary> salaries = repository.getAllSalaries();

		for (Salary salary : salaries) {
			System.out.println(salary);
		}

//		System.out.println("\n\n***********GET SALARY BY ID***********");
//
//		Salary salaryById = repository.getSalaryByID((short) 3);
//		System.out.println(salaryById);

//		System.out.println("\n\n***********GET SALARY BY NAME***********");
//
//		Salary salaryByName = repository.getSalaryByName(600);
//		System.out.println(salaryByName);

//		System.out.println("\n\n***********CREATE Salary***********");
//
//		Salary salaryCreate = new Salary();
//		salaryCreate.setSalaryName(Salary.SalaryName.PM);
//		repository.createSalary(salaryCreate);

//		System.out.println("\n\n***********UPDATE SALARY 1***********");
//
//		repository.updateSalary((short) 1, 2000);

//		System.out.println("\n\n***********UPDATE SALARY 2***********");
//
//		Salary salaryUpdate = new Salary();
//		salaryUpdate.setSalaryId((short) 1);
//		salaryUpdate.setSalaryName(600);
//		repository.updateSalary(salaryUpdate);

//		System.out.println("\n\n***********DELETE SALARY***********");
//		repository.deleteSalary((short) 6);

//		System.out.println("***********CHECK SALARY EXISTS BY ID***********");
//		System.out.println(repository.isSalaryExistsByID((short) 6));

//		System.out.println("***********CHECK SALARY EXISTS BY NAME***********");
//		System.out.println(repository.isSalaryExistsByName(600));

	}
}
