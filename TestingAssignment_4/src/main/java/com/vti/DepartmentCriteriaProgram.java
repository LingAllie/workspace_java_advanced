package com.vti;

import com.vti.entity.DepartmentDTO;
import com.vti.repository.DepartmentCriteriaRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class DepartmentCriteriaProgram
{
    // Initial Repositories
    private static DepartmentCriteriaRepository departmentCriteriaRepository = new DepartmentCriteriaRepository();

    public static void main( String[] args )
    {
        int choice;

        do {
            EntityServiceMenu.DepartmentCriteriaMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            String ord = null, name = null;
            int pageNumber = -1, pageSize = -1;
            short point = -1;

            switch (choice) {
                case 1:
                    // Test getAllDepartments
                    if (getYesNoInput("Do you want to sort the list by name ?\n1:Yes | 2:No: ") == 1) {
                        ord = ScannerUtils.inputString("Enter type of sorting if you want (ASC/DESC): ");
                    }

                    if (getYesNoInput("Do you want to view list with paging ?\n1:Yes | 2:No: ") == 1) {
                        pageNumber = ScannerUtils.inputNumInt("Enter page number: ");
                        pageSize = ScannerUtils.inputNumInt("Enter page size: ");
                    }

                    List<DepartmentDTO> departmentList = departmentCriteriaRepository.getAllDepartments(ord, pageNumber, pageSize, name, point);
                    for (DepartmentDTO department : departmentList) {
                        System.out.println(department);
                    }
                    break;

                case 2:
                    // Search department by name
                    name = ScannerUtils.inputString("Enter department name: ");
                    departmentList = departmentCriteriaRepository.getAllDepartments(ord, pageNumber, pageSize, name, point);
                    for (DepartmentDTO department : departmentList) {
                        System.out.println(department);
                    }
                    break;

                case 3:
                    // Get department has emulation point more than given point
                    point = ScannerUtils.inputNumShort("Enter emulation point: ");
                    departmentList = departmentCriteriaRepository.getAllDepartments(ord, pageNumber, pageSize, name, point);
                    for (DepartmentDTO department : departmentList) {
                        System.out.println(department);
                    }
                    break;

                case 4:
                    // Get total count extends search by name or filter by point
                    if (getYesNoInput("Get total count by searched name ?\n 1:Yes | 2:No: ") == 1) {
                        name = ScannerUtils.inputString("Enter department name: ");
                    }
                    if (getYesNoInput("Get total count by emulation point ?\n 1:Yes | 2:No: ") == 1) {
                        point = ScannerUtils.inputNumShort("Enter emulation point: ");
                    }
                    System.out.println("Total department: " + departmentCriteriaRepository.getTotalCount(name, point));
                    break;

                case 5:
                    // Check if department exist by ID
                    short id = ScannerUtils.inputNumShort("Enter department id: ");
                    System.out.println(departmentCriteriaRepository.isDepartmentExistById(id));
                    break;

                case 6:
                    // Check if department exist by name
                    name = ScannerUtils.inputString("Enter department name: ");
                    System.out.println(departmentCriteriaRepository.isDepartmentExistByName(name));
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    // Utility method to repeatedly ask Yes/No question until valid input is provided
    private static int getYesNoInput(String message) {
        int input;
        while (true) {
            input = ScannerUtils.inputNumInt(message);
            if (input == 1 || input == 2) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter 1 for Yes or 2 for No.");
            }
        }
    }
}
