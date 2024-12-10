package com.vti;

import com.vti.entity.*;
import com.vti.repository.*;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class DepartmentHQLProgram
{
    // Initial Repositories
    private static DepartmentHQLRepository departmentHQLRepository = new DepartmentHQLRepository();

    public static void main( String[] args )
    {
        int choice;

        do {
            EntityServiceMenu.DepartmentHQLMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            String ord = null, name = null;
            int pageNumber = -1, pageSize = -1, point = -1;

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

                    List<DepartmentDTO> departmentList = departmentHQLRepository.getAllDepartments(ord, pageNumber, pageSize, name, point);
                    for (DepartmentDTO department : departmentList) {
                        System.out.println(department);
                    }
                    break;

                case 2:
                    // Search department by name
                    name = ScannerUtils.inputString("Enter department name: ");
                    departmentList = departmentHQLRepository.getAllDepartments(ord, pageNumber, pageSize, name, point);
                    for (DepartmentDTO department : departmentList) {
                        System.out.println(department);
                    }
                    break;

                case 3:
                    // Get department has emulation point more than given point
                    point = ScannerUtils.inputNumInt("Enter emulation point: ");
                    departmentList = departmentHQLRepository.getAllDepartments(ord, pageNumber, pageSize, name, point);
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
                        point = ScannerUtils.inputNumInt("Enter emulation point: ");
                    }
                    System.out.println("Total department: " + departmentHQLRepository.getTotalCount(name, point));
                    break;

                case 5:
                    short addressId = -1, emulationPoint = -1;
                    String addressName = null;

                    // Update department, address, emulation point
                    short departmentId = ScannerUtils.inputNumShort("Enter department id: ");
                    String departmentName = ScannerUtils.inputString("Enter update department name: ");
                    if (getYesNoInput("Do you want to update address in detail department table ?\n (1. Yes | 2.No): ") == 1) {
                        addressId = ScannerUtils.inputNumShort("Enter update address id: ");
                        addressName = ScannerUtils.inputString("Enter address name: ");
                    }

                    if (getYesNoInput("Do you want to update emulation point ?\n (1. Yes | 2.No): ") == 1) {
                        emulationPoint = ScannerUtils.inputNumShort("Enter emulation point: ");
                    }

                    departmentHQLRepository.updateDepartment(departmentId, departmentName, addressId, addressName, emulationPoint);
                    break;

                case 6:
                    // Delete department
                    short id = ScannerUtils.inputNumShort("Enter department id: ");
                    departmentHQLRepository.deleteDepartment(id);
                    break;

                case 7:
                    // Create department
                    id = ScannerUtils.inputNumShort("Enter department id: ");
                    name = ScannerUtils.inputString("Enter department name: ");
                    departmentHQLRepository.createDepartment(new Department(id, name));
                    break;

                case 8:
                    // Check if department exist by ID
                    id = ScannerUtils.inputNumShort("Enter department id: ");
                    System.out.println(departmentHQLRepository.isDepartmentExistById(id));
                    break;

                case 9:
                    // Check if department exist by name
                    name = ScannerUtils.inputString("Enter department name: ");
                    System.out.println(departmentHQLRepository.isDepartmentExistByName(name));
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
