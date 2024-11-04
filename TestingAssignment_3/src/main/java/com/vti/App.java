package com.vti;

import com.vti.repository.*;
import com.vti.entity.*;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class App 
{
    // Initial Repositories
    private static DepartmentRepository departmentRepository = new DepartmentRepository();
    private static AddressRepository addressRepository = new AddressRepository();
    private static DetailDepartmentRepository detailDepartmentRepository = new DetailDepartmentRepository();
    private static PositionRepository positionRepository = new PositionRepository();
    private static SalaryRepository salaryRepository = new SalaryRepository();
    private static AccountRepository accountRepository = new AccountRepository();
    private static EmployeeRepository employeeRepository = new EmployeeRepository();
    private static ManagerRepository managerRepository = new ManagerRepository();
    private static GroupRepository groupRepository = new GroupRepository();
    private static GroupAccountRepository groupAccountRepository = new GroupAccountRepository();
    private static TypeQuestionRepository typeQuestionRepository = new TypeQuestionRepository();
    private static CategoryQuestionRepository categoryQuestionRepository = new CategoryQuestionRepository();
    private static QuestionRepository questionRepository = new QuestionRepository();
    private static AnswerRepository answerRepository = new AnswerRepository();
    private static ExamRepository examRepository = new ExamRepository();
    private static ExamQuestionRepository examQuestionRepository = new ExamQuestionRepository();

    public static void main( String[] args )
    {
        String choice = menu();

        while(true) {

            switch (Integer.parseInt(choice)) {
                case 1:
                    AddressProgram();
                    choice = menu();
                    break;

                case 2:
                    DepartmentProgram();
                    choice = menu();
                    break;

                case 3:
                    DetailDepartmentProgram();
                    choice = menu();
                    break;

                case 4:
                    PositionProgram();
                    choice = menu();
                    break;

                case 5:
                    SalaryProgram();
                    choice = menu();
                    break;

                case 6:
                    AccountProgram();
                    choice = menu();
                    break;

                case 7:
                    EmployeeProgram();
                    choice = menu();
                    break;

                case 8:
                    ManagerProgram();
                    choice = menu();
                    break;

                case 9:
                    GroupProgram();
                    choice = menu();
                    break;

                case 10:
                    GroupAccountProgram();
                    choice = menu();
                    break;

                case 11:
                    TypeQuestionProgram();
                    choice = menu();
                    break;

                case 12:
                    CategoryQuestionProgram();
                    choice = menu();
                    break;

                case 13:
                    QuestionProgram();
                    choice = menu();
                    break;

                case 14:
                    AnswerProgram();
                    choice = menu();
                    break;

                case 15:
                    ExamProgram();
                    choice = menu();
                    break;

                case 16:
                    ExamQuestionProgram();
                    choice = menu();
                    break;

                case 0:
                    System.out.println("End main program...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static String menu() {
        System.out.println("Select a program to run: ");
        System.out.println("1. Address Program");
        System.out.println("2. Department Program");
        System.out.println("3. Detail Department Program");
        System.out.println("4. Position Program");
        System.out.println("5. Salary Program");
        System.out.println("6. Account Program");
        System.out.println("7. Employee Program");
        System.out.println("8. Manager Program");
        System.out.println("9. Group Program");
        System.out.println("10. Group Account Program");
        System.out.println("11. Type Question Program");
        System.out.println("12. Category Question Program");
        System.out.println("13. Question Program");
        System.out.println("14. Answer Program");
        System.out.println("15. Exam Program");
        System.out.println("16. Exam Question Program");
        System.out.println("0. Exit");
        return ScannerUtils.inputString("Enter your program option: ");
    }

    private static void AddressProgram() {

        int choice;

        do {
            EntityServiceMenu.AddressProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // Test getAllAddresses
                    List<Address> addressList = addressRepository.getAllAddresses();
                    for (Address address : addressList) {
                        System.out.println(address);
                    }
                    break;

                case 2:
                    // Create a new Address
                    String addressName = ScannerUtils.inputString("Enter address name: ");
                    Address newAddress = new Address();
                    newAddress.setAddressName(addressName);
                    addressRepository.createAddress(newAddress);
                    break;

                case 3:
                    // Test getAddressById
                    short id = ScannerUtils.inputNumShort("Enter address ID: ");
                    Address fetchedAddressById = addressRepository.getAddressById(id);
                    if (fetchedAddressById != null) {
                        System.out.println("Address found: " + fetchedAddressById);
                    } else {
                        System.out.println("Address not found.");
                    }
                    break;

                case 4:
                    // Test getAddressByName
                    String name = ScannerUtils.inputString("Enter address name(P000): ");
                    Address fetchedAddressByName = addressRepository.getAddressByName(name);
                    if (fetchedAddressByName != null) {
                        System.out.println("Address found: " + fetchedAddressByName);
                    } else {
                        System.out.println("Address not found.");
                    }
                    break;

                case 5:
                    // Test updateAddress
                    short updateId = ScannerUtils.inputNumShort("Enter address ID: ");
                    String newAddressName = ScannerUtils.inputString("Enter new address name: ");
                    addressRepository.updateAddressName(new Address(updateId, newAddressName));
                    addressRepository.getAddressById(updateId);
                    break;

                case 6:
                    // Test deleteAddress
                    short deleteId = ScannerUtils.inputNumShort("Enter address ID: ");
                    addressRepository.deleteAddress(deleteId);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void DepartmentProgram() {

        int choice;

        do {
            EntityServiceMenu.DepartmentProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // Test getAllDepartments
                    List<Department> departmentList = departmentRepository.getAllDepartments();
                    for (Department department : departmentList) {
                        System.out.println(department);
                    }
                    break;

                case 2:
                    // Create a new Department
                    String departmentName = ScannerUtils.inputString("Enter department name: ");
                    Department newDepartment = new Department();
                    newDepartment.setDepartmentName(departmentName);
                    departmentRepository.createDepartment(newDepartment);
                    break;

                case 3:
                    // Test getDepartmentById
                    short id = ScannerUtils.inputNumShort("Enter department ID: ");
                    Department fetchedDepartmentById = departmentRepository.getDepartmentById(id);
                    if (fetchedDepartmentById != null) {
                        System.out.println("Department found: " + fetchedDepartmentById);
                    } else {
                        System.out.println("Department not found.");
                    }
                    break;

                case 4:
                    // Test getDepartmentByName
                    String name = ScannerUtils.inputString("Enter department name: ");
                    Department fetchedDepartmentByName = departmentRepository.getDepartmentByName(name);
                    if (fetchedDepartmentByName != null) {
                        System.out.println("Department found: " + fetchedDepartmentByName);
                    } else {
                        System.out.println("Department not found.");
                    }
                    break;

                case 5:
                    // Test updateDepartment
                    short updateId = ScannerUtils.inputNumShort("Enter department ID: ");
                    String newDepartmentName = ScannerUtils.inputString("Input new department name: ");
                    departmentRepository.updateDepartmentName(new Department(updateId, newDepartmentName));
                    departmentRepository.getDepartmentById(updateId);
                    break;

                case 6:
                    // Test deleteAddress
                    short deleteId = ScannerUtils.inputNumShort("Enter department ID: ");
                    departmentRepository.deleteDepartment(deleteId);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void DetailDepartmentProgram() {

        int choice;

        do {
            EntityServiceMenu.DetailDepartmentProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    short departmentId = ScannerUtils.inputNumShort("Enter department ID to match: ");
                    while ( departmentRepository.getDepartmentById(departmentId) == null ||
                            ((departmentRepository.getDepartmentById(departmentId) != null) &&
                                    (detailDepartmentRepository.getDetailDepartmentByDepartmentId(departmentId) != null)) ) {
                        departmentId = ScannerUtils.inputNumShort("Department has matched or not exist!...\nPlease enter new department ID has exist in department table but has not been matched: ");
                    }
                    short addressId = ScannerUtils.inputNumShort("Enter address ID to match: ");
                    short point = ScannerUtils.inputNumShort("Enter emulation point: ");
                    detailDepartmentRepository.createDetailDepartment(departmentId, addressId, point);
                    break;

                case 2:
                    // Get All DetailDepartments
                    List<DetailDepartment> detailDepartments = detailDepartmentRepository.getAllDetailDepartment();
                    for (DetailDepartment detailDepartment : detailDepartments) {
                        System.out.println(detailDepartment);
                    }
                    break;

                case 3:
                    // Get DetailDepartment by Emulation Point
                    short keyPoint = ScannerUtils.inputNumShort("Enter Emulation Point: ");
                    List<DetailDepartment> detailDepartmentsByPoint = detailDepartmentRepository.getDetailDepartmentByEmulationPoint(keyPoint);
                    if (!detailDepartmentsByPoint.isEmpty()) {
                        for (DetailDepartment detailDepartment : detailDepartmentsByPoint) {
                            System.out.println(detailDepartment);
                        }
                    } else {
                        System.out.println("DetailDepartment not found.");
                    }
                    break;

                case 4:
                    // Get DetailDepartment by Department ID
                    short keyDepartmentId = ScannerUtils.inputNumShort("Enter Department ID: ");
                    DetailDepartment detailDepartmentByDepartmentId = detailDepartmentRepository.getDetailDepartmentByDepartmentId(keyDepartmentId);
                    System.out.println(detailDepartmentByDepartmentId != null ? detailDepartmentByDepartmentId : "DetailDepartment not found.");
                    break;

                case 5:
                    // Get DetailDepartment by Address ID
                    short keyAddressId = ScannerUtils.inputNumShort("Enter Address ID: ");
                    List<DetailDepartment> detailDepartmentByAddressId = detailDepartmentRepository.getDetailDepartmentByAddressId(keyAddressId);
                    if (!detailDepartmentByAddressId.isEmpty()) {
                        for (DetailDepartment detailDepartment : detailDepartmentByAddressId) {
                            System.out.println(detailDepartment);
                        }
                    } else {
                        System.out.println("DetailDepartment not found.");
                    }
                    break;

                case 6:
                    // Update Emulation Point by Department ID
                    short deptIdToUpdate = ScannerUtils.inputNumShort("Enter Department ID: ");
                    short newPoint = ScannerUtils.inputNumShort("Enter new Emulation Point: ");
                    detailDepartmentRepository.updateEmulationPointByDepartmentId(deptIdToUpdate, newPoint);
                    detailDepartmentRepository.getDetailDepartmentByDepartmentId(deptIdToUpdate);
                    break;

                case 7:
                    // Delete DetailDepartment by Department ID
                    short deptIdToDelete = ScannerUtils.inputNumShort("Enter Department ID: ");
                    detailDepartmentRepository.deleteDetailDepartmentByDepartmentId(deptIdToDelete);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void PositionProgram() {

        int choice;

        do {
            EntityServiceMenu.PositionProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // Test getAllPositions
                    List<Position> positions = positionRepository.getAllPositions();
                    for (Position position : positions) {
                        System.out.println(position);
                    }
                    break;

                case 2:
                    // Test createPosition
                    short positionId = ScannerUtils.inputNumShort("Choose position's index (1-DEV, 2-TEST, 3-SCRUMMASTER, 4-PM): ");
                    while (positionRepository.getPositionById(positionId) != null) {
                        positionId = ScannerUtils.inputNumShort("Position has existed !\n Please choose new position's index (1-DEV, 2-TEST, 3-SCRUMMASTER, 4-PM): ");
                    }
                    Position newPosition = new Position();
                    newPosition.setPositionName(positionRepository.getPositionById(positionId).getPositionName());
                    positionRepository.createPosition(newPosition);
                    break;

                case 3:
                    // Test getPositionById
                    short id = ScannerUtils.inputNumShort("Enter position ID: ");
                    Position positionById = positionRepository.getPositionById(id);
                    if (positionById != null) {
                        System.out.println("Position found: " + positionById);
                    } else {
                        System.out.println("Position not found.");
                    }
                    break;

                case 4:
                    // Test deletePositionById
                    short deleteId = ScannerUtils.inputNumShort("Enter position ID to delete: ");
                    positionRepository.deletePositionById(deleteId);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);
    }

    private static void SalaryProgram() {

        int choice;

        do {
            EntityServiceMenu.SalaryProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // Test getAllSalaries
                    List<Salary> salaryList = salaryRepository.getAllSalaries();
                    for (Salary salary : salaryList) {
                        System.out.println(salary);
                    }
                    break;

                case 2:
                    // Create a new Salary
                    String salaryName = ScannerUtils.inputString("Enter salary name: ");
                    Salary newSalary = new Salary();
                    newSalary.setSalaryName(Salary.SalaryName.valueOf(salaryName.toUpperCase()));
                    salaryRepository.createSalary(newSalary);
                    break;

                case 3:
                    // Test getSalaryById
                    short id = ScannerUtils.inputNumShort("Enter salary ID: ");
                    Salary fetchedSalaryById = salaryRepository.getSalaryById(id);
                    if (fetchedSalaryById != null) {
                        System.out.println("Salary found: " + fetchedSalaryById);
                    } else {
                        System.out.println("Salary not found.");
                    }
                    break;

                case 4:
                    // Test getSalaryByName
                    short index = ScannerUtils.inputNumShort("Enter salary name index (1-600, 2-700, 3-1500, 4-2000): ");
                    Salary fetchedSalaryByName = salaryRepository.getSalaryByName(index);
                    if (fetchedSalaryByName != null) {
                        System.out.println("Salary found: " + fetchedSalaryByName);
                    } else {
                        System.out.println("Salary not found.");
                    }
                    break;

                case 5:
                    // Test updateSalary
                    short salaryIdBefore = ScannerUtils.inputNumShort("Enter current salary ID: ");
                    short salaryIdAfter = ScannerUtils.inputNumShort("Enter new salary ID: ");
                    salaryRepository.updateSalary(salaryIdBefore, salaryIdAfter);
                    break;

                case 6:
                    // Test deleteSalary
                    short deleteId = ScannerUtils.inputNumShort("Enter salary ID to delete: ");
                    salaryRepository.deleteSalary(deleteId);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void AccountProgram() {
        int choice;

        do {
            // Displaying the menu options
            EntityServiceMenu.AccountProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // Test getAllAccounts
                    List<Account> accountList = accountRepository.getAllAccounts();
                    for (Account account : accountList) {
                        System.out.println(account);
                    }
                    break;

                case 2:
                    // Create a new Account
                    String email = ScannerUtils.inputString("Enter email: ");
                    String username = ScannerUtils.inputString("Enter username: ");
                    String firstName = ScannerUtils.inputString("Enter your first name: ");
                    String lastName = ScannerUtils.inputString("Enter your last name: ");
                    Department department = departmentRepository.getDepartmentById(ScannerUtils.inputNumShort("Your department ID: "));
                    while (department == null) {
                        department = departmentRepository.getDepartmentById(ScannerUtils.inputNumShort("Department ID not exist, enter new department ID: "));
                    }
                    Position position = positionRepository.getPositionById(ScannerUtils.inputNumShort("Your position ID: "));
                    while (position == null) {
                        position = positionRepository.getPositionById(ScannerUtils.inputNumShort("Position ID not exist, enter new position ID: "));
                    }
                    Salary salary = salaryRepository.getSalaryById(ScannerUtils.inputNumShort("Your salary ID: "));
                    while (position == null) {
                        salary = salaryRepository.getSalaryById(ScannerUtils.inputNumShort("Salary ID not exist, enter new salary ID: "));
                    }
                    Account newAccount = new Account(email, username, firstName, lastName, department, position, salary);
                    accountRepository.createAccount(newAccount);
                    break;

                case 3:
                    // Test getAccountById
                    short id = ScannerUtils.inputNumShort("Enter account ID: ");
                    Account fetchedAccountById = accountRepository.getAccountById(id);
                    if (fetchedAccountById != null) {
                        System.out.println("Account found: " + fetchedAccountById);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    // Test getAccountByUsername
                    String name = ScannerUtils.inputString("Enter username: ");
                    Account fetchedAccountByUsername = accountRepository.getAccountByUsername(name);
                    if (fetchedAccountByUsername != null) {
                        System.out.println("Account found: " + fetchedAccountByUsername);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    // Test updateAccount
                    short updateId = ScannerUtils.inputNumShort("Enter account ID to update: ");
                    Account accountToUpdate = accountRepository.getAccountById(updateId);
                    if (accountToUpdate != null) {
                        switch (ScannerUtils.inputNumInt("Choose update option (1. Department | 2. Position | 3. Salary): ")) {
                            case 1:
                                // update department
                                Department departmentToUpdate = departmentRepository.getDepartmentById(ScannerUtils.inputNumShort("Enter update department ID: "));

                                while(departmentToUpdate == null) {
                                    departmentToUpdate = departmentRepository.getDepartmentById(ScannerUtils.inputNumShort("Department not exist !\nEnter update department ID: "));
                                }

                                accountToUpdate.setDepartment(departmentToUpdate);
                                break;
                            case 2:
                                // Update position
                                Position positionToUpdate = positionRepository.getPositionById(ScannerUtils.inputNumShort("Enter update position ID: "));

                                while(positionToUpdate == null) {
                                    positionToUpdate = positionRepository.getPositionById(ScannerUtils.inputNumShort("Position not exist !\nEnter update position ID: "));
                                }

                                accountToUpdate.setPosition(positionToUpdate);
                                break;
                            case 3:
                                // Update salary
                                Salary salaryToUpdate = salaryRepository.getSalaryById(ScannerUtils.inputNumShort("Enter update salary ID: "));

                                while(salaryToUpdate == null) {
                                    salaryToUpdate = salaryRepository.getSalaryById(ScannerUtils.inputNumShort("Salary not exist !\nEnter update salary ID: "));
                                }

                                accountToUpdate.setSalary(salaryToUpdate);
                                break;
                        }

                        accountRepository.updateAccount(accountToUpdate);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    // Test deleteAccount
                    short deleteId = ScannerUtils.inputNumShort("Enter account ID to delete: ");
                    accountRepository.deleteAccount(deleteId);
                    System.out.println("Account with ID " + deleteId + " has been deleted.");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void EmployeeProgram() {
        int choice;

        do {
            // Displaying the menu options
            EntityServiceMenu.EmployeeProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // View all employees
                    List<Employee> employeeList = employeeRepository.getAllEmployees();
                    for (Employee employee : employeeList) {
                        System.out.println(employee);
                    }
                    break;

                case 2:
                    // Add new employee
                    short accountId = ScannerUtils.inputNumShort("Enter account ID: ");
                    short workingExperience = ScannerUtils.inputNumShort("Enter working experience (years): ");
                    Employee newEmployee = new Employee();
                    newEmployee.setAccount(accountRepository.getAccountById(accountId));
                    newEmployee.setWorkingNumberOfYear(workingExperience);
                    employeeRepository.createEmployee(newEmployee);
                    break;

                case 3:
                    // View employee by ID
                    short id = ScannerUtils.inputNumShort("Enter employee ID: ");
                    Employee fetchedEmployeeById = employeeRepository.getEmployeeById(id);
                    if (fetchedEmployeeById != null) {
                        System.out.println("Employee found: " + fetchedEmployeeById);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    // View employees by working experience
                    short experience = ScannerUtils.inputNumShort("Enter working experience (years): ");
                    List<Employee> employeesByExperience = employeeRepository.getEmployeeByWorkingExperience(experience);
                    if (employeesByExperience.isEmpty()) {
                        System.out.println("No employees found with " + experience + " years of experience.");
                    } else {
                        for (Employee employee : employeesByExperience) {
                            System.out.println(employee);
                        }
                    }
                    break;

                case 5:
                    // Update employee
                    short updateId = ScannerUtils.inputNumShort("Enter employee ID to update: ");
                    Employee employeeToUpdate = employeeRepository.getEmployeeById(updateId);
                    if (employeeToUpdate != null) {
                        short newExperience = ScannerUtils.inputNumShort("Enter new working experience (leave as 0 to keep current): ");
                        if (newExperience > 0) {
                            employeeToUpdate.setWorkingNumberOfYear(newExperience);
                        }
                        employeeRepository.updateEmployeeWorkingExperience(employeeToUpdate);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 6:
                    // Delete employee
                    short deleteId = ScannerUtils.inputNumShort("Enter employee ID to delete: ");
                    if (employeeRepository.getEmployeeById(deleteId) != null) {
                        employeeRepository.deleteEmployee(deleteId);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void ManagerProgram() {
        int choice;

        do {
            // Displaying the menu options
            EntityServiceMenu.ManagerProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // View all managers
                    List<Manager> managerList = managerRepository.getAllManagers();
                    for (Manager manager : managerList) {
                        System.out.println(manager);
                    }
                    break;

                case 2:
                    // Add new manager
                    short accountId = ScannerUtils.inputNumShort("Enter account ID: ");
                    short manageExperience = ScannerUtils.inputNumShort("Enter manage experience (years): ");
                    Manager newManager = new Manager();
                    newManager.setAccount(accountRepository.getAccountById(accountId));
                    newManager.setManagementNumberOfYear(manageExperience);
                    managerRepository.createManager(newManager);
                    break;

                case 3:
                    // View manager by ID
                    short id = ScannerUtils.inputNumShort("Enter manager ID: ");
                    Manager fetchedManagerById = managerRepository.getManagerById(id);
                    if (fetchedManagerById != null) {
                        System.out.println("Manager found: " + fetchedManagerById);
                    } else {
                        System.out.println("Manager not found.");
                    }
                    break;

                case 4:
                    // View managers by working experience
                    short experience = ScannerUtils.inputNumShort("Enter manage experience (years): ");
                    List<Manager> managersByExperience = managerRepository.getManagerByManageExperience(experience);
                    if (managersByExperience.isEmpty()) {
                        System.out.println("No managers found with " + experience + " years of experience.");
                    } else {
                        for (Manager manager : managersByExperience) {
                            System.out.println(manager);
                        }
                    }
                    break;

                case 5:
                    // Update manager
                    short updateId = ScannerUtils.inputNumShort("Enter manager ID to update: ");
                    Manager managerToUpdate = managerRepository.getManagerById(updateId);
                    if (managerToUpdate != null) {
                        short newExperience = ScannerUtils.inputNumShort("Enter new manage experience (leave as 0 to keep current): ");
                        if (newExperience > 0) {
                            managerToUpdate.setManagementNumberOfYear(newExperience);
                        }
                        managerRepository.updateManagerManageExperience(managerToUpdate);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 6:
                    // Delete manager
                    short deleteId = ScannerUtils.inputNumShort("Enter manager ID to delete: ");
                    if (managerRepository.getManagerById(deleteId) != null) {
                        managerRepository.deleteManager(deleteId);
                    } else {
                        System.out.println("Manager not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void GroupProgram() {
        int choice;

        do {
            // Displaying the menu options
            EntityServiceMenu.GroupProgramMenu();  // Assuming you have a method to display the menu
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // View all groups
                    List<Group> groupList = groupRepository.getAllGroups();
                    if (groupList.isEmpty()) {
                        System.out.println("No groups found.");
                    } else {
                        for (Group group : groupList) {
                            System.out.println(group);
                        }
                    }
                    break;

                case 2:
                    // Add new group
                    String groupName = ScannerUtils.inputString("Enter group name: ");
                    while(groupRepository.getGroupByName(groupName) != null) {
                        groupName = ScannerUtils.inputString("Group name has existed !\nEnter new group name: ");
                    }
                    short creatorId = ScannerUtils.inputNumShort("Enter creator ID: ");
                    Group newGroup = new Group(groupName, accountRepository.getAccountById(creatorId));
                    groupRepository.createGroup(newGroup);
                    break;

                case 3:
                    // View group by ID
                    short id = ScannerUtils.inputNumShort("Enter group ID: ");
                    Group fetchedGroupById = groupRepository.getGroupById(id);
                    if (fetchedGroupById != null) {
                        System.out.println("Group found: " + fetchedGroupById);
                    } else {
                        System.out.println("Group not found.");
                    }
                    break;

                case 4:
                    // View group by name
                    String name = ScannerUtils.inputString("Enter group name: ");
                    Group fetchedGroupByName = groupRepository.getGroupByName(name);
                    if (fetchedGroupByName != null) {
                        System.out.println("Group found: " + fetchedGroupByName);
                    } else {
                        System.out.println("Group not found.");
                    }
                    break;

                case 5:
                    // Update group name
                    short updateId = ScannerUtils.inputNumShort("Enter group ID to update: ");
                    Group groupToUpdate = groupRepository.getGroupById(updateId);
                    if (groupToUpdate != null) {
                        String newGroupName = ScannerUtils.inputString("Enter new group name: ");
                        if (!newGroupName.isEmpty()) {
                            groupToUpdate.setGroupName(newGroupName);
                        }
                        groupRepository.updateGroupName(groupToUpdate);
                    } else {
                        System.out.println("Group not found.");
                    }
                    break;

                case 6:
                    // Delete group
                    short deleteId = ScannerUtils.inputNumShort("Enter group ID to delete: ");
                    if (groupRepository.getGroupById(deleteId) != null) {
                        groupRepository.deleteGroup(deleteId);
                    } else {
                        System.out.println("Group not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void GroupAccountProgram() {
        int choice;

        do {
            // Displaying the menu options
            EntityServiceMenu.GroupAccountProgramMenu();  // Assuming you have a method to display the menu
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // View all group accounts
                    List<GroupAccount> groupAccountList = groupAccountRepository.getAllGroupAccounts();
                    for (GroupAccount groupAccount : groupAccountList) {
                        System.out.println(groupAccount);
                    }
                    break;

                case 2:
                    // Add new group account
                    short groupId = ScannerUtils.inputNumShort("Enter group ID: ");
                    short accountId = ScannerUtils.inputNumShort("Enter account ID: ");
                    GroupAccount newGroupAccount = new GroupAccount();
                    newGroupAccount.setGroup(groupRepository.getGroupById(groupId));
                    newGroupAccount.setAccount(accountRepository.getAccountById(accountId));
                    GroupAccount.GroupAccountId groupAccountId = new GroupAccount.GroupAccountId();
                    groupAccountId.setAccountId(accountId);
                    groupAccountId.setGroupId(groupId);
                    newGroupAccount.setId(groupAccountId);
                    groupAccountRepository.createGroupAccount(newGroupAccount);
                    break;

                case 3:
                    // Get group accounts by group ID
                    short searchGroupId = ScannerUtils.inputNumShort("Enter group ID to search for accounts: ");
                    List<GroupAccount> foundGroupAccounts = groupAccountRepository.getGroupAccountByGroupId(searchGroupId);
                    if (foundGroupAccounts.isEmpty()) {
                        System.out.println("No accounts found in group ID " + searchGroupId);
                    } else {
                        for (GroupAccount groupAccount : foundGroupAccounts) {
                            System.out.println(groupAccount);
                        }
                    }
                    break;

                case 4:
                    // Get group accounts by account ID
                    short searchAccountId = ScannerUtils.inputNumShort("Enter account ID to search for accounts: ");
                    foundGroupAccounts = groupAccountRepository.getGroupAccountByAccountId(searchAccountId);
                    if (foundGroupAccounts.isEmpty()) {
                        System.out.println("No accounts found in group ID " + searchAccountId);
                    } else {
                        for (GroupAccount groupAccount : foundGroupAccounts) {
                            System.out.println(groupAccount);
                        }
                    }
                    break;

                case 5:
                    // Get group account by group ID and account ID
                    searchGroupId = ScannerUtils.inputNumShort("Enter group ID: ");
                    searchAccountId = ScannerUtils.inputNumShort("Enter account ID: ");

                    GroupAccount groupAccount = groupAccountRepository.getGroupAccountByGroupIdAndAccountId(searchGroupId, searchAccountId);
                    System.out.println(groupAccount != null ? groupAccount : "Group account not found.");
                    break;

                case 6:
                    // Delete all accounts by group ID
                    short deleteGroupId = ScannerUtils.inputNumShort("Enter group ID to delete all accounts: ");
                    groupAccountRepository.deleteGroupAccountByGroupId(deleteGroupId);
                    break;

                case 7:
                    // Delete a specific account from a group
                    short delGroupId = ScannerUtils.inputNumShort("Enter group ID: ");
                    short delAccountId = ScannerUtils.inputNumShort("Enter account ID to delete from group: ");
                    groupAccountRepository.deleteAccountFromGroup(delGroupId, delAccountId);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void TypeQuestionProgram() {

        int choice;

        do {
            EntityServiceMenu.TypeQuestionProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // Test getAllPositions
                    List<TypeQuestion> typeQuestions = typeQuestionRepository.getAllTypeQuestions();
                    for (TypeQuestion typeQuestion : typeQuestions) {
                        System.out.println(typeQuestion);
                    }
                    break;

                case 2:
                    // Test get TypeQuestion by id
                    short id = ScannerUtils.inputNumShort("Enter type ID: ");
                    TypeQuestion typeQuestionById = typeQuestionRepository.getTypeQuestionById(id);
                    if (typeQuestionById != null) {
                        System.out.println("Position found: " + typeQuestionById);
                    } else {
                        System.out.println("Position not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);
    }

    public static void CategoryQuestionProgram() {
        int choice;

        do {
            EntityServiceMenu.CategoryQuestionProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // Retrieve and display all CategoryQuestions
                    List<CategoryQuestion> categoryQuestions = categoryQuestionRepository.getAllCategoryQuestions();
                    for (CategoryQuestion categoryQuestion : categoryQuestions) {
                        System.out.println(categoryQuestion);
                    }
                    break;

                case 2:
                    // Create a new CategoryQuestion
                    String categoryName = ScannerUtils.inputString("Enter category name: ");
                    while (categoryQuestionRepository.checkExistCategoryQuestionByName(categoryName)) {
                        categoryName = ScannerUtils.inputString("Enter category name: ");
                    }
                    CategoryQuestion newCategoryQuestion = new CategoryQuestion();
                    newCategoryQuestion.setCategoryName(categoryName);
                    categoryQuestionRepository.createCategoryQuestion(newCategoryQuestion);
                    break;

                case 3:
                    // Retrieve a CategoryQuestion by ID
                    short id = ScannerUtils.inputNumShort("Enter category question ID: ");
                    CategoryQuestion fetchedCategoryById = categoryQuestionRepository.getCategoryQuestionById(id);
                    if (fetchedCategoryById != null) {
                        System.out.println("CategoryQuestion found: " + fetchedCategoryById);
                    } else {
                        System.out.println("CategoryQuestion not found.");
                    }
                    break;

                case 4:
                    // Retrieve CategoryQuestions by name
                    String name = ScannerUtils.inputString("Enter category name: ");
                    List<CategoryQuestion> fetchedCategoriesByName = categoryQuestionRepository.getCategoryQuestionByName(name);
                    if (!fetchedCategoriesByName.isEmpty()) {
                        for (CategoryQuestion categoryQuestion : fetchedCategoriesByName) {
                            System.out.println(categoryQuestion);
                        }
                    } else {
                        System.out.println("No CategoryQuestion found with the given name.");
                    }
                    break;

                case 5:
                    // Update CategoryQuestion name
                    short updateId = ScannerUtils.inputNumShort("Enter category question ID: ");
                    String newCategoryName = ScannerUtils.inputString("Input new category name: ");
                    CategoryQuestion updateCategory = new CategoryQuestion();
                    updateCategory.setCategoryId(updateId);
                    updateCategory.setCategoryName(newCategoryName);
                    categoryQuestionRepository.updateCategoryQuestionName(updateCategory);
                    break;

                case 6:
                    // Delete a CategoryQuestion by ID
                    short deleteId = ScannerUtils.inputNumShort("Enter category question ID: ");
                    categoryQuestionRepository.deleteCategoryQuestion(deleteId);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void QuestionProgram() {
        int choice;

        do {
            EntityServiceMenu.QuestionProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // Get all questions
                    List<Question> questionList = questionRepository.getAllQuestions();
                    for (Question question : questionList) {
                        System.out.println(question);
                    }
                    break;

                case 2:
                    // Create a new question
                    String content = ScannerUtils.inputString("Enter question content: ");

                    short categoryId = ScannerUtils.inputNumShort("Enter category ID: ");
                    while (categoryQuestionRepository.getCategoryQuestionById(categoryId) == null) {
                        categoryId = ScannerUtils.inputNumShort("Category not exist !\n Please enter new category ID: ");
                    }

                    short typeId = ScannerUtils.inputNumShort("Enter type ID: ");
                    while (typeQuestionRepository.getTypeQuestionById(typeId) == null) {
                        typeId = ScannerUtils.inputNumShort("Type not exist !\n Please enter new type ID: ");
                    }

                    short creatorId = ScannerUtils.inputNumShort("Enter creator ID: ");
                    System.out.println(questionRepository.getQuestionByCreator(creatorId));
                    while (!questionRepository.getQuestionByCreator(creatorId).isEmpty()) {
                        creatorId = ScannerUtils.inputNumShort("Creator not exist or has created question !\n Please enter new creator ID: ");
                    }

                    Question newQuestion = new Question();
                    newQuestion.setContent(content);
                    newQuestion.setCategory(categoryQuestionRepository.getCategoryQuestionById(categoryId));
                    newQuestion.setType(typeQuestionRepository.getTypeQuestionById(typeId));
                    newQuestion.setCreator(accountRepository.getAccountById(creatorId));

                    questionRepository.createQuestion(newQuestion);
                    break;

                case 3:
                    // Get question by ID
                    short id = ScannerUtils.inputNumShort("Enter question ID: ");
                    Question questionById = questionRepository.getQuestionById(id);
                    if (questionById != null) {
                        System.out.println("Question found: " + questionById);
                    } else {
                        System.out.println("Question not found.");
                    }
                    break;

                case 4:
                    // Get questions by content
                    String searchContent = ScannerUtils.inputString("Enter content to search for: ");
                    List<Question> questionsByContent = questionRepository.getQuestionByContent(searchContent);
                    if (questionsByContent.isEmpty()) {
                        System.out.println("No questions found with that content.");
                    } else {
                        for (Question q : questionsByContent) {
                            System.out.println(q);
                        }
                    }
                    break;

                case 5:
                    // Get questions by category
                    short searchCategoryId = ScannerUtils.inputNumShort("Enter category ID to search: ");
                    List<Question> questionsByCategory = questionRepository.getQuestionByCategory(searchCategoryId);
                    if (questionsByCategory.isEmpty()) {
                        System.out.println("No questions found in that category.");
                    } else {
                        for (Question q : questionsByCategory) {
                            System.out.println(q);
                        }
                    }
                    break;

                case 6:
                    // Get questions by type
                    short searchTypeId = ScannerUtils.inputNumShort("Enter type ID to search: ");
                    List<Question> questionsByType = questionRepository.getQuestionByType(searchTypeId);
                    if (questionsByType.isEmpty()) {
                        System.out.println("No questions found with that type.");
                    } else {
                        for (Question q : questionsByType) {
                            System.out.println(q);
                        }
                    }
                    break;

                case 7:
                    // Get questions by creator
                    short searchCreatorId = ScannerUtils.inputNumShort("Enter creator ID to search: ");
                    List<Question> questionsByCreator = questionRepository.getQuestionByCreator(searchCreatorId);
                    if (questionsByCreator.isEmpty()) {
                        System.out.println("No questions found for that creator.");
                    } else {
                        for (Question q : questionsByCreator) {
                            System.out.println(q);
                        }
                    }
                    break;

                case 8:
                    // Update a question
                    short updateId = ScannerUtils.inputNumShort("Enter question ID to update: ");
                    Question questionToUpdate = questionRepository.getQuestionById(updateId);
                    if (questionToUpdate != null) {
                        int updateOption = ScannerUtils.inputNumInt("Enter update option (1. content | 2. Category | 3. Type): ");
                        switch (updateOption) {
                            case 1:
                                questionToUpdate.setContent(ScannerUtils.inputString("Enter new content: "));
                                break;
                            case 2:
                                questionToUpdate.setCategory(categoryQuestionRepository.getCategoryQuestionById(ScannerUtils.inputNumShort("Enter category ID to update: ")));
                                break;
                            case 3:
                                questionToUpdate.setType(typeQuestionRepository.getTypeQuestionById(ScannerUtils.inputNumShort("Enter type ID to update: ")));
                                break;
                        }

                        questionRepository.updateQuestion(questionToUpdate);
                    } else {
                        System.out.println("Question not found.");
                    }
                    break;

                case 9:
                    // Delete a question
                    short deleteId = ScannerUtils.inputNumShort("Enter question ID to delete: ");
                    questionRepository.deleteQuestion(deleteId);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void AnswerProgram() {
        int choice;

        do {
            EntityServiceMenu.AnswerProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // Get all answers
                    List<Answer> answers = answerRepository.getAllAnswers();
                    for (Answer answer : answers) {
                        System.out.println(answer);
                    }
                    break;

                case 2:
                    // Create a new answer
                    String content = ScannerUtils.inputString("Enter answer content: ");
                    boolean isCorrect = ScannerUtils.inputBoolean("Is this answer correct? (true/false): ");
                    short questionId = ScannerUtils.inputNumShort("Enter question ID for this answer: ");
                    while (questionRepository.getQuestionById(questionId) == null) {
                        questionId = ScannerUtils.inputNumShort("Question not exist !\nPlease enter new question ID for this answer: ");
                    }
                    Answer newAnswer = new Answer(content, questionRepository.getQuestionById(questionId), isCorrect);
                    answerRepository.createAnswer(newAnswer);
                    break;

                case 3:
                    // Get answer by ID
                    short id = ScannerUtils.inputNumShort("Enter answer ID: ");
                    Answer answer = answerRepository.getAnswerById(id);
                    System.out.println(answer != null ? answer : "Answer not found.");
                    break;

                case 4:
                    // Get answer by content
                    String searchContent = ScannerUtils.inputString("Enter content to search for answers: ");
                    List<Answer> answersByContent = answerRepository.getAnswerByContent(searchContent);
                    if (!answersByContent.isEmpty()) {
                        for (Answer ans : answersByContent) {
                            System.out.println(ans);
                        }
                    } else {
                        System.out.println("Answer not found.");
                    }
                    break;

                case 5:
                    // Get answers by question ID
                    short questionIdSearch = ScannerUtils.inputNumShort("Enter question ID to search for answers: ");
                    List<Answer> answersByQuestionId = answerRepository.getAnswerByQuestionId(questionIdSearch);
                    if (!answersByQuestionId.isEmpty()) {
                        for (Answer ans : answersByQuestionId) {
                            System.out.println(ans);
                        }
                    } else {
                        System.out.println("Answer not found.");
                    }
                    break;

                case 6:
                    // Get answers by correct status
                    boolean status = ScannerUtils.inputBoolean("Enter correct status (true/false): ");
                    List<Answer> answersByStatus = answerRepository.getAnswerByCorrectStatus(status);
                    if (!answersByStatus.isEmpty()) {
                        for (Answer ans : answersByStatus) {
                            System.out.println(ans);
                        }
                    } else {
                        System.out.println("Answer not found.");
                    }
                    break;

                case 7:
                    // Update an answer
                    short updateId = ScannerUtils.inputNumShort("Enter answer ID to update: ");
                    Answer updateAnswer = answerRepository.getAnswerById(updateId);
                    if (updateAnswer != null) {
                        switch (ScannerUtils.inputNumInt("Choose option update (1. Content | 2. Status): ")) {
                            case 1:
                                String newContent = ScannerUtils.inputString("Enter new content: ");
                                updateAnswer.setContent(newContent);
                                break;
                            case 2:
                                boolean newStatus = ScannerUtils.inputBoolean("Status for this answer (true/false): ");
                                updateAnswer.setCorrect(newStatus);
                                break;
                        }

                        answerRepository.updateAnswer(updateAnswer);
                    } else {
                        System.out.println("Answer not found.");
                    }
                    break;

                case 8:
                    // Delete an answer
                    short deleteId = ScannerUtils.inputNumShort("Enter answer ID to delete: ");
                    answerRepository.deleteAnswer(deleteId);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void ExamProgram() {
        int choice;

        do {
            EntityServiceMenu.ExamProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // Get all exams
                    List<Exam> exams = examRepository.getAllExams();
                    for (Exam exam : exams) {
                        System.out.println(exam);
                    }
                    break;

                case 2:
                    // Create a new exam
                    String title = ScannerUtils.inputString("Enter exam title: ");

                    short categoryId = ScannerUtils.inputNumShort("Enter category ID for this exam: ");
                    while (categoryQuestionRepository.getCategoryQuestionById(categoryId) == null) {
                        categoryId = ScannerUtils.inputNumShort("Category not found! Please enter a valid category ID: ");
                    }

                    short duration = ScannerUtils.inputNumShort("Enter exam duration (in minutes): ");

                    short creatorId = ScannerUtils.inputNumShort("Enter creator ID: ");
                    while (accountRepository.getAccountById(creatorId) == null) {
                        creatorId = ScannerUtils.inputNumShort("Creator not found! Please enter a valid creator ID: ");
                    }

                    Exam newExam = new Exam(title, categoryQuestionRepository.getCategoryQuestionById(categoryId), duration, accountRepository.getAccountById(creatorId));
                    examRepository.createExam(newExam);
                    break;

                case 3:
                    // Get exam by ID
                    short id = ScannerUtils.inputNumShort("Enter exam ID: ");
                    Exam exam = examRepository.getExamById(id);
                    System.out.println(exam != null ? exam : "Exam not found.");
                    break;

                case 4:
                    // Get exams by code
                    String searchCode = ScannerUtils.inputString("Enter code to search for exams: ");
                    List<Exam> examsByCode = examRepository.getExamsByCode(searchCode);
                    if (!examsByCode.isEmpty()) {
                        for (Exam ex : examsByCode) {
                            System.out.println(ex);
                        }
                    } else {
                        System.out.println("Exams not found.");
                    }
                    break;

                case 5:
                    // Get exams by title
                    String searchTitle = ScannerUtils.inputString("Enter title to search for exams: ");
                    List<Exam> examsByTitle = examRepository.getExamByTitle(searchTitle);
                    if (!examsByTitle.isEmpty()) {
                        for (Exam ex : examsByTitle) {
                            System.out.println(ex);
                        }
                    } else {
                        System.out.println("Exams not found.");
                    }
                    break;

                case 6:
                    // Get exams by category ID
                    short searchCategoryId = ScannerUtils.inputNumShort("Enter category ID to search for exams: ");
                    List<Exam> examsByCategory = examRepository.getExamByCategory(searchCategoryId);
                    if (!examsByCategory.isEmpty()) {
                        for (Exam ex : examsByCategory) {
                            System.out.println(ex);
                        }
                    } else {
                        System.out.println("Exams not found.");
                    }
                    break;

                case 7:
                    // Get exams by duration
                    short searchDuration = ScannerUtils.inputNumShort("Enter duration (in minutes) to search for exams: ");
                    List<Exam> examsByDuration = examRepository.getExamByDuration(searchDuration);
                    if (!examsByDuration.isEmpty()) {
                        for (Exam ex : examsByDuration) {
                            System.out.println(ex);
                        }
                    } else {
                        System.out.println("Exams not found.");
                    }
                    break;

                case 8:
                    // Get exams by creator ID
                    short searchCreatorId = ScannerUtils.inputNumShort("Enter creator ID to search for exams: ");
                    List<Exam> examsByCreator = examRepository.getExamByCreator(searchCreatorId);
                    if (!examsByCreator.isEmpty()) {
                        for (Exam ex : examsByCreator) {
                            System.out.println(ex);
                        }
                    } else {
                        System.out.println("Exams not found.");
                    }
                    break;

                case 9:
                    // Update an exam
                    short updateId = ScannerUtils.inputNumShort("Enter exam ID to update: ");
                    Exam updateExam = examRepository.getExamById(updateId);
                    if (updateExam != null) {
                        switch (ScannerUtils.inputNumInt("Choose option to update (1. Title | 2. Category | 3.Duration): ")) {
                            case 1:
                                String newTitle = ScannerUtils.inputString("Enter new title: ");
                                updateExam.setTitle(newTitle);
                                break;
                            case 2:
                                short newCategory = ScannerUtils.inputNumShort("Enter new category id: ");
                                while (categoryQuestionRepository.getCategoryQuestionById(newCategory) == null) {
                                    newCategory = ScannerUtils.inputNumShort("Category not found! Please enter a valid category ID: ");
                                }
                                updateExam.setCategory(categoryQuestionRepository.getCategoryQuestionById(newCategory));
                                break;
                            case 3:
                                short newDuration = ScannerUtils.inputNumShort("Enter new duration: ");
                                updateExam.setDuration(newDuration);
                                break;
                        }
                        examRepository.updateExam(updateExam);
                    } else {
                        System.out.println("Exam not found.");
                    }
                    break;

                case 10:
                    // Delete an exam
                    short deleteId = ScannerUtils.inputNumShort("Enter exam ID to delete: ");
                    Exam deleteExam = examRepository.getExamById(deleteId);
                    if (deleteExam != null) {
                        examRepository.deleteExam(deleteExam);
                    } else {
                        System.out.println("Exam not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void ExamQuestionProgram() {
        int choice;

        do {
            EntityServiceMenu.ExamQuestionProgramMenu();
            choice = ScannerUtils.inputNumInt("Enter your option: ");

            switch (choice) {
                case 1:
                    // Get all exam questions
                    List<ExamQuestion> examQuestions = examQuestionRepository.getAllExamQuestions();
                    for (ExamQuestion eq : examQuestions) {
                        System.out.println(eq);
                    }
                    break;

                case 2:
                    // Create a new exam question
                    short examId = ScannerUtils.inputNumShort("Enter exam ID: ");
                    short questionId = ScannerUtils.inputNumShort("Enter question ID: ");

                    ExamQuestion newExamQuestion = new ExamQuestion(new ExamQuestion.ExamQuestionId(examId, questionId), examRepository.getExamById(examId), questionRepository.getQuestionById(questionId));
                    examQuestionRepository.createExamQuestion(newExamQuestion);
                    break;

                case 3:
                    // Get exam questions by exam ID
                    short searchExamId = ScannerUtils.inputNumShort("Enter exam ID to search: ");
                    List<ExamQuestion> examQuestionsByExam = examQuestionRepository.getExamQuestionByExamId(searchExamId);
                    if (!examQuestionsByExam.isEmpty()) {
                        for (ExamQuestion eq : examQuestionsByExam) {
                            System.out.println(eq);
                        }
                    } else {
                        System.out.println("No exam questions found for this exam ID.");
                    }
                    break;

                case 4:
                    // Get exam questions by question ID
                    short searchQuestionId = ScannerUtils.inputNumShort("Enter question ID to search: ");
                    List<ExamQuestion> examQuestionsByQuestion = examQuestionRepository.getExamQuestionByQuestionId(searchQuestionId);
                    if (!examQuestionsByQuestion.isEmpty()) {
                        for (ExamQuestion eq : examQuestionsByQuestion) {
                            System.out.println(eq);
                        }
                    } else {
                        System.out.println("No exam questions found for this question ID.");
                    }
                    break;

                case 5:
                    // Get exam question by exam ID and question ID
                    short searchExamIdForQuestion = ScannerUtils.inputNumShort("Enter exam ID: ");
                    short searchQuestionIdForExam = ScannerUtils.inputNumShort("Enter question ID: ");

                    ExamQuestion examQuestion = examQuestionRepository.getExamQuestionByExamIdAndQuestionId(searchExamIdForQuestion, searchQuestionIdForExam);
                    System.out.println(examQuestion != null ? examQuestion : "Exam question not found.");
                    break;

                case 6:
                    // Delete all exams by exam ID
                    short deleteExamId = ScannerUtils.inputNumShort("Enter exam ID to delete all exams group: ");
                    examQuestionRepository.deleteExamQuestionByExamId(deleteExamId);
                    break;

                case 7:
                    // Delete a specific account from a group
                    short delExamId = ScannerUtils.inputNumShort("Enter exam ID: ");
                    short delQuestionId = ScannerUtils.inputNumShort("Enter question ID to delete from group: ");
                    examQuestionRepository.deleteQuestionFromExam(delExamId, delQuestionId);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

}
